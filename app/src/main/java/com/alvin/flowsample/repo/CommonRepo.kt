package com.alvin.flowsample.repo

import com.alvin.flowsample.network.data.ApiService
import com.alvin.flowsample.network.data.Resource
import com.alvin.flowsample.network.models.post.BasePostModel
import com.alvin.flowsample.repo.db.CommonDbRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CommonRepo @Inject constructor(
    private val apiService: ApiService,
    private val commonDbRepo: CommonDbRepo,
) {
    suspend fun getPost() = flow<Resource<BasePostModel>> {
        kotlin.runCatching {
            emit(Resource.Loading(null))
            apiService.getPost()
        }.onSuccess {
            if (it.isSuccessful) {
                emit(Resource.Success(it.body()!!))
                commonDbRepo.insertPost(it.body()!!)
            } else {
                emit(Resource.Error(Exception(it.message())))
            }
        }.onFailure {
            emit(Resource.Error(it))
        }
    }.flowOn(Dispatchers.IO)
}