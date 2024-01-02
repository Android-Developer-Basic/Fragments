package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentA: Fragment(R.layout.fragment_a) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    view.findViewById<MaterialButton>(R.id.buttonOpenFragmentAA).setOnClickListener {
      openFragmentAA()
    }

    initOnBackPressedHandler()
  }

  private fun openFragmentAA() {
    val color = ColorGenerator.generateColor()

    childFragmentManager.beginTransaction()
      .replace(R.id.fragmentContainer, FragmentAA.create(color))
      .addToBackStack(null)
      .commit()
  }

  private fun initOnBackPressedHandler() {
    requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
      override fun handleOnBackPressed() {
        if (childFragmentManager.backStackEntryCount > 0) {
          childFragmentManager.popBackStack()
        } else if (parentFragmentManager.backStackEntryCount > 1) {
          parentFragmentManager.popBackStack()
        } else {
          activity?.finish()
        }
      }
    })
  }
}