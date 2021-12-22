package com.alvin.flowsample.extentions

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


fun <T> LifecycleOwner.lifeCycleLaunchWithFlow(value: Flow<T>, callBack: (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            value.collectLatest {
                callBack(it)
            }
        }
    }
}

fun <T> ViewModel.viewModelLaunchWithFlow(value: Flow<T>, callBack: (T) -> Unit) {
    viewModelScope.launch(Dispatchers.Default) {
        value.collectLatest {
            callBack(it)
        }
    }
}

fun <T> LifecycleOwner.liveDataObserver(value: LiveData<T>, f: (T) -> Unit) {
    value.observe(this, Observer { f(it) })
}

