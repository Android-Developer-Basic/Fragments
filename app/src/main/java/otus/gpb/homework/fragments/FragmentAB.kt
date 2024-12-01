package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


class FragmentAB : Fragment(R.layout.fragment_a_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { view.setBackgroundColor(it.getInt(COLOR)) }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                }
                else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    companion object {
        private const val COLOR = "color"

        fun withArgs(value: Int) : FragmentAB {
            val fragment = FragmentAB()
            val arguments = Bundle()
            arguments.putInt(COLOR, value)
            fragment.arguments = arguments
            return  fragment
        }
    }
}