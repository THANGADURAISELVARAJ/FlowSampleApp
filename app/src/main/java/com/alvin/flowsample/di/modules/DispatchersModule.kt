package com.alvin.flowsample.di.modules

import com.alvin.flowsample.di.customAnnotations.DefaultDispatcher
import com.alvin.flowsample.di.customAnnotations.IoDispatcher
import com.alvin.flowsample.di.customAnnotations.MainDispatcher
import com.alvin.flowsample.di.customAnnotations.UnconfinedDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @MainDispatcher
    @Singleton
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @IoDispatcher
    @Singleton
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DefaultDispatcher
    @Singleton
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default


    @Provides
    @UnconfinedDispatcher
    @Singleton
    fun provideUnconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined
}