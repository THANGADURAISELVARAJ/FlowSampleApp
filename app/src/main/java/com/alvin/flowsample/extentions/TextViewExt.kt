package com.alvin.flowsample.extentions

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.animation.addListener
import androidx.core.view.ViewCompat
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
/**
 * Animate the text color of any view that extends [TextView] (Buttons, EditText...).
 *
 * @param duration   the duration of the animation
 * @param colorStart the text color to start with
 * @param colorEnd   the text color to end with
 */
fun TextView.animateTextColor(duration: Long, @ColorInt colorStart: Int, @ColorInt colorEnd: Int) {
    val viewPropertyAnimator = ValueAnimator.ofObject(ArgbEvaluator(), colorStart, colorEnd)
    viewPropertyAnimator.interpolator = FastOutSlowInInterpolator()
    viewPropertyAnimator.duration = duration
    viewPropertyAnimator.addUpdateListener { setTextColor(it.animatedValue as Int) }
    viewPropertyAnimator.addListener(onCancel = { setTextColor(colorEnd) }, onEnd = { setTextColor(colorEnd) })
    viewPropertyAnimator.start()
}
inline var View.backgroundTintListCompat: ColorStateList?
    get() = ViewCompat.getBackgroundTintList(this)
    set(value) = ViewCompat.setBackgroundTintList(this, value)

fun View.animateBackgroundColor(duration: Long, @ColorInt colorStart: Int, @ColorInt colorEnd: Int) {

    val empty = arrayOf(IntArray(0))
    val viewPropertyAnimator = ValueAnimator.ofObject(ArgbEvaluator(), colorStart, colorEnd)
    viewPropertyAnimator.interpolator = FastOutSlowInInterpolator()
    viewPropertyAnimator.duration = duration
    viewPropertyAnimator.addUpdateListener { animation: ValueAnimator ->
        backgroundTintListCompat = ColorStateList(empty, intArrayOf(animation.animatedValue as Int))
    }
    viewPropertyAnimator.addListener(
        onCancel = { backgroundTintListCompat = ColorStateList(empty, intArrayOf(colorEnd)) },
        onEnd = { backgroundTintListCompat = ColorStateList(empty, intArrayOf(colorEnd)) }
    )
    viewPropertyAnimator.start()
}

fun View.animateHeight(duration: Long, targetHeight: Int): ValueAnimator {
    val s = if (targetHeight != this.height){
        targetHeight
    }else{
        targetHeight + targetHeight
    }
    val animator = ValueAnimator.ofFloat(height.toFloat(), s.toFloat())
    animator.interpolator = FastOutSlowInInterpolator()
    animator.duration = duration
    animator.addUpdateListener { animation: ValueAnimator ->
        val value = animation.animatedValue as Float
        layoutParams.height = value.toInt()
        requestLayout()
    }
    animator.addListener(
        onCancel = {
            layoutParams.height = s
            requestLayout()
        },
        onEnd = {
            layoutParams.height = s
            requestLayout()
        }
    )
    animator.start()
    return animator
}
