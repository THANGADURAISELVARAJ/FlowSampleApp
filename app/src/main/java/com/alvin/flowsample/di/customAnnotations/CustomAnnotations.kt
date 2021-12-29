package com.alvin.flowsample.di.customAnnotations

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class IoDispatcher

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class MainDispatcher

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class DefaultDispatcher


@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class UnconfinedDispatcher