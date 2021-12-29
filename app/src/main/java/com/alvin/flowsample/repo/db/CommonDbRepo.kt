package com.alvin.flowsample.repo.db

import com.alvin.flowsample.db.roomDb.AppDatabase
import com.alvin.flowsample.network.models.post.BasePostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CommonDbRepo @Inject constructor(private val db: AppDatabase) {

    suspend fun insertPost(postModel: BasePostModel) {
        withContext(Dispatchers.IO) {
            db.appDao().insertRestaurants(postModel)
        }
    }

    suspend fun deletePost() {
        withContext(Dispatchers.IO) {
            db.appDao().deleteAllRestaurants()
        }
    }

    fun getPost() = db.appDao().getAllRestaurants()

}