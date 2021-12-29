package com.alvin.flowsample.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import coil.ImageLoader
import coil.load
import coil.transform.CircleCropTransformation
import com.alvin.flowsample.databinding.ActivityMainBinding
import com.alvin.flowsample.db.preferenceDb.PrefKeys
import com.alvin.flowsample.db.preferenceDb.PrefStore
import com.alvin.flowsample.extentions.lifeCycleLaunch
import com.alvin.flowsample.extentions.lifeCycleLaunchWithFlow
import com.alvin.flowsample.extentions.liveDataObserver
import com.alvin.flowsample.extentions.registerListeners
import com.alvin.flowsample.network.data.Resource
import com.alvin.flowsample.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : BaseActivity(), View.OnClickListener {

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var prefStore: PrefStore

    private lateinit var mainBinding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        mainBinding.apply {
            mainViewModel.apply {
                liveDataObserver(liveData) {
                    liveDataTxt.text = it.toString()
                }
            }

            registerListeners(btnSaveData, btnApiCalling, btnImageLoadWithCoil)
        }
    }

    override fun onClick(v: View) {
        mainBinding.apply {
            when (v) {
                btnSaveData -> {
                    lifeCycleLaunchWithFlow(prefStore.getValue(PrefKeys.USER_FIRST_NAME)) {
                        it?.let {
                            tvSavedData.text = it
                        }
                    }

                    lifeCycleLaunch {
                        prefStore.saveValue(PrefKeys.USER_FIRST_NAME, "alvin")
                    }

                }
                btnApiCalling -> {

                    mainViewModel.apply {
                        getPost()
                        getPostInOffline()

                        liveDataObserver(postData) {
                            when (it) {
                                is Resource.Success -> {
                                    liveDataTxt.text =
                                        ("Success ${it.data?.take(1)?.get(0)?.body}")
                                }
                                is Resource.Error -> {
                                    liveDataTxt.text = ("Fail ${it.error?.message}")
                                }
                                is Resource.Loading -> {
                                    liveDataTxt.text = ("Load")
                                }
                            }

                        }

                        liveDataObserver(postDataInOffline) {
                            if (it.isNotEmpty()) {
                                textView.text = (it.get(0).body)
                            }
                        }
                    }
                }
                btnImageLoadWithCoil -> {
                    imageView.load("https://images.unsplash.com/profile-1446404465118-3a53b909cc82?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=27a346c2362207494baa7b76f5d606e5") {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }
                }
            }
        }
    }
}