package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentAB : Fragment(R.layout.fragment_ab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = arguments?.getInt(ARG_COLOR)
        color?.let { view.setBackgroundColor(color) }
    }

    companion object {
        private const val ARG_COLOR = "arg_color"

        fun create(value: Int): FragmentAB {
            val fragment = FragmentAB()
            val arguments = Bundle()
            arguments.putInt(ARG_COLOR, value)
            fragment.arguments = arguments
            return fragment
        }
    }
}
