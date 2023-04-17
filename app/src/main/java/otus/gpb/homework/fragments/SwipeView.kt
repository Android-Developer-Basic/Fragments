package otus.gpb.homework.fragments

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.view.View

class SwipeView(private val view:View?,
                    private val animatorDuration: Long,
                    private val animationInterpolator: TimeInterpolator,
){
    fun swipe(start:Float, finish:Float){
        view?.let { v ->
            ValueAnimator.ofFloat(start, finish)
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

    fun unWrap(start: Int, finish:Int){
        view?.let { v ->
            ValueAnimator.ofInt(start, finish).apply {
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