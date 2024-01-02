package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentBB : Fragment(R.layout.fragment_bb) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val bgColor = Color.YELLOW
    view.setBackgroundColor(bgColor)

    view.findViewById<MaterialButton>(R.id.btnSendColor).setOnClickListener {
      generateAndSendColorToFragmentBA()
      closeFragmentIfPortraitOrientation()
    }
  }

  private fun generateAndSendColorToFragmentBA() {
    val color = ColorGenerator.generateColor()
    val bundle = FragmentBA.getBundleForResultListener(color)

    parentFragmentManager.setFragmentResult(FragmentBA.RESULT_COLOR_KEY, bundle)
  }

  private fun closeFragmentIfPortraitOrientation() {
    val orientation = resources.configuration.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
      parentFragmentManager.popBackStack()
    }
  }
}