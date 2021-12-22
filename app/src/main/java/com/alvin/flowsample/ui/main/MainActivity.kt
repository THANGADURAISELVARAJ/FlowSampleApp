package com.alvin.flowsample.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.alvin.flowsample.databinding.ActivityMainBinding
import com.alvin.flowsample.extentions.lifeCycleLaunchWithFlow
import com.alvin.flowsample.extentions.liveDataObserver
import com.alvin.flowsample.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.apply {
            mainViewModel.apply {
                liveDataObserver(liveData) {
                    mainBinding.liveDataTxt.text = it.toString()
                }
                btn.setOnClickListener {
                    lifeCycleLaunchWithFlow(timer) {
                        textView.text = it.toString()
                    }
                    incrementLiveData()
                }
            }
        }
    }
}