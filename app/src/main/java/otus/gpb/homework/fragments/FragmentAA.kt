package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentAA: Fragment(R.layout.fragment_aa) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    arguments?.getInt(ARG_COLOR)?.let { color: Int ->
      view.setBackgroundColor(color)
    }

    view.findViewById<MaterialButton>(R.id.buttonOpenFragmentAB).setOnClickListener {
      openFragmentAB()
    }
  }

  private fun openFragmentAB() {
    val color = ColorGenerator.generateColor()

    parentFragmentManager.beginTransaction()
      .replace(R.id.fragmentContainer, FragmentAB.create(color))
      .addToBackStack(null)
      .commit()
  }

  companion object {
    private const val ARG_COLOR = "color"

    fun create(color: Int): FragmentAA = FragmentAA().apply {
      arguments = Bundle().apply {
        putInt(ARG_COLOR, color)
      }
    }
  }
}