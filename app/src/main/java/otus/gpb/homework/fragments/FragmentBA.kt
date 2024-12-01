package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentBA : Fragment(R.layout.fragment_ba) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val bgColor = arguments?.getInt(ARG_COLOR) ?: Color.BLUE
    view.setBackgroundColor(bgColor)

    showContentIfPortraitOrientation(view)
    initResultListener(view)
  }

  private fun showContentIfPortraitOrientation(view: View) {
    val orientation = resources.configuration.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
      view.findViewById<MaterialButton>(R.id.btnOpenFragmentBB).apply {
        visibility = View.VISIBLE

        setOnClickListener {
          openFragmentBB()
        }
      }
    }
  }

  private fun openFragmentBB() {
    parentFragmentManager.beginTransaction()
      .replace(R.id.fragmentContainer1, FragmentBB())
      .addToBackStack(null)
      .commit()
  }

  private fun initResultListener(view: View) {
    parentFragmentManager.setFragmentResultListener(RESULT_COLOR_KEY, viewLifecycleOwner) { _, res: Bundle ->
      val newBgColor = res.getInt(ARG_COLOR)
      view.setBackgroundColor(newBgColor)
    }
  }

  companion object {
    private const val ARG_COLOR = "color"
    const val RESULT_COLOR_KEY = "color"

    fun getBundleForResultListener(color: Int) = bundleOf().apply {
      putInt(ARG_COLOR, color)
    }
  }
}