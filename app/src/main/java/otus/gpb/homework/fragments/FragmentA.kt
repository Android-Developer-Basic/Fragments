package otus.gpb.homework.fragments


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentA: Fragment(R.layout.a_fragment) {

    override fun onAttach(context: Context) {
        super.onAttach(context)

    val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (childFragmentManager.backStackEntryCount > 0) {
                childFragmentManager.popBackStack()
            } else {
                isEnabled = false
                activity?.onBackPressed()
            }
        }
    }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ColorGenerator.generateColor())
        view.findViewById<Button>(R.id.openFragmentAA).setOnClickListener {
                parentFragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentAA())
                        .addToBackStack("")
                        .commit()

            }
    }
}