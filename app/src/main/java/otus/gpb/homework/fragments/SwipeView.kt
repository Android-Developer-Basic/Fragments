package otus.gpb.homework.fragments

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.view.View

class SwipeView(private val view:View?,
                    private val animatorDuration: Long,
                    private val animationInterpolator: TimeInterpolator,
){
    fun swipe(){
        view?.let { v ->
            ValueAnimator.ofFloat(v.x, -1*v.width.toFloat())
                .apply {
                duration = animatorDuration
                interpolator = animationInterpolator
                addUpdateListener {
                    val animatedValue = it.animatedValue as Float
                    v.x = animatedValue
                    v.invalidate()
                }
                start()
            }


        }
    }

    fun unWrap(){
        view?.let { v ->
            ValueAnimator.ofInt(v.width, 0).apply {
                duration = animatorDuration
                interpolator = animationInterpolator
                addUpdateListener {
                    val animatedValue = it.animatedValue as Int
                    v.left = animatedValue
                    v.invalidate()

                }
                start()
            }
        }
    }



}