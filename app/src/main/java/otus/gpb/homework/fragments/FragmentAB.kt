package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback

class FragmentAB : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    val background = arguments?.getInt(ARG_VALUE)
    if (background != null) {
        view.setBackgroundColor(background)
    }
}
companion object {
    private const val ARG_VALUE = "backcolor"
    fun create(value: Int): FragmentAB {
        val fragment = FragmentAB()
        val arguments = Bundle()
        arguments.putInt(ARG_VALUE, value)
        fragment.arguments = arguments
        return fragment
    }
}

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
}