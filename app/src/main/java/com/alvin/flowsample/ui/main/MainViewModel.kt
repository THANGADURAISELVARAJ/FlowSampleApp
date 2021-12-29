package com.alvin.flowsample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvin.flowsample.network.data.Resource
import com.alvin.flowsample.network.models.post.BasePostModel
import com.alvin.flowsample.network.models.post.BasePostModelItem
import com.alvin.flowsample.repo.CommonRepo
import com.alvin.flowsample.repo.db.CommonDbRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val commonRepo: CommonRepo,
    private val commonDbRepo: CommonDbRepo,
) : ViewModel() {

    private val _liveData = MutableLiveData(0)
    val liveData = _liveData

    private val _postData = MutableLiveData<Resource<BasePostModel>>()
    val postData = _postData

    private val _postDataInOffline = MutableLiveData<List<BasePostModelItem>>()
    val postDataInOffline = _postDataInOffline

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

    fun getPost() {
        viewModelScope.launch {
            commonRepo.getPost().collectLatest {
                _postData.value = it
            }
        }
    }

    fun getPostInOffline() {
        viewModelScope.launch {
            commonDbRepo.getPost().collectLatest {
                postDataInOffline.value = it
            }
        }
    }
}