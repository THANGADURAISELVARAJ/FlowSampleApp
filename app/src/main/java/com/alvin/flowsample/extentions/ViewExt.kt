package com.alvin.flowsample.extentions

import android.view.View

fun View.OnClickListener.registerListeners(vararg view: View) {
    view.forEach {
        it.setOnClickListener(this)
    }
}