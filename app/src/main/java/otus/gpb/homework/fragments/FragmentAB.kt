package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentAB: Fragment(R.layout.fragment_ab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newColor = arguments?.getInt(FragmentAB.ARG_VALUE)
        newColor?.let {  view.setBackgroundColor(it) }
    }

    companion object {
        private const val ARG_VALUE = "value"
        fun create(value: Int): FragmentAB {
            val fragment = FragmentAB()
            val arguments = Bundle()
            arguments.putInt(ARG_VALUE, value)
            fragment.arguments = arguments
            return fragment
        }
    }
}