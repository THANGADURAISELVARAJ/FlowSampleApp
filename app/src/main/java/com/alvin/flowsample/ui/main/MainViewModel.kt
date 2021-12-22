package com.alvin.flowsample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _liveData = MutableLiveData(0)
    val liveData = _liveData

    val timer = flow {
        val startValue = 10
        var currentValue = startValue
        while (currentValue > 0) {
            delay(500)
            emit(currentValue)
            currentValue--
        }
    }

    fun incrementLiveData() {
        _liveData.postValue(_liveData.value?.plus(1))
    }
}