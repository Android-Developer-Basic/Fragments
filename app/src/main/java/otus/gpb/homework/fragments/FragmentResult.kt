package otus.gpb.homework.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.LifecycleOwner

private const val F_RESULT_KEY = "fResult"
private const val FM_RESULT_KEY = "fmResult"
private const val COLOR_KEY = "color"

fun Fragment.sendColor(color: Int) {
    setFragmentResult(F_RESULT_KEY, bundleOf(COLOR_KEY to color))
    setFragmentResult(FM_RESULT_KEY, bundleOf(COLOR_KEY to color))
}

fun Fragment.applyColor(callback: (Int)->Unit) {
    setFragmentResultListener(F_RESULT_KEY) { _, bundle ->
        callback(bundle.getInt(COLOR_KEY, 0))
    }
}

fun FragmentManager.observeColor(lifecycleOwner: LifecycleOwner, callback: (Int)->Unit) {
    setFragmentResultListener(FM_RESULT_KEY, lifecycleOwner) {_, bundle ->
        callback(bundle.getInt(COLOR_KEY, 0))
    }
}