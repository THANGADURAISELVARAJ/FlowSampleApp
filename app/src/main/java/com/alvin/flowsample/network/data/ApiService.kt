package com.alvin.flowsample.network.data

import com.alvin.flowsample.network.constants.ApiEndPoints
import com.alvin.flowsample.network.models.post.BasePostModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ApiEndPoints.END_POINT_POST)
    suspend fun getPost(): Response<BasePostModel>
}