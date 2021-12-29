package com.alvin.flowsample.di.modules

import com.alvin.flowsample.network.constants.ApiBaseUrl
import com.alvin.flowsample.network.constants.ApiConstants
import com.alvin.flowsample.network.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiBaseUrl.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
        return client.apply {
            addInterceptor(httpLoggingInterceptor)
            callTimeout(ApiConstants.SIXTY_SECONDS, TimeUnit.SECONDS)
            connectTimeout(ApiConstants.SIXTY_SECONDS, TimeUnit.SECONDS)
            readTimeout(ApiConstants.SIXTY_SECONDS, TimeUnit.SECONDS)
            writeTimeout(ApiConstants.SIXTY_SECONDS, TimeUnit.SECONDS)
        }.build()
    }

}