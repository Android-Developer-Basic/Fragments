package otus.gpb.homework.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

private const val REQUEST_KEY = "fragment_bb_request_key"
private const val RESULT_BUNDLE_KEY = "fragment_bb_result_bundle_key"

fun Fragment.sendResult(color: Int) {
    parentFragmentManager.setFragmentResult(
        REQUEST_KEY,
        bundleOf(RESULT_BUNDLE_KEY to color)
    )
}

fun Fragment.observeResult(callback: (Int) -> Unit) {
    parentFragmentManager.setFragmentResultListener(REQUEST_KEY, this) { _, result ->
        val backgroundColor = result.getInt(RESULT_BUNDLE_KEY)
        callback(backgroundColor)
    }
}