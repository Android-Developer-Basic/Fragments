package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentAB: Fragment(R.layout.fragment_ab) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    arguments?.getInt(ARG_COLOR)?.let { color: Int ->
      view.setBackgroundColor(color)
    }
  }

  companion object {
    private const val ARG_COLOR = "color"

    fun create(color: Int): FragmentAB = FragmentAB().apply {
      arguments = Bundle().apply {
        putInt(ARG_COLOR, color)
      }
    }
  }
}
