package otus.gpb.homework.fragments.taskA

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import otus.gpb.homework.fragments.R


class FragmentAB : Fragment(R.layout.fragment_a_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorBackground = arguments?.getInt(ARG_VALUE)
        if (colorBackground != null) {
            view.setBackgroundColor(colorBackground)
        }
    }

    companion object {

        private const val ARG_VALUE = "color_background"

        fun create(value: Int): FragmentAB {
            val fragment = FragmentAB()
            val argument = Bundle()
            argument.putInt(ARG_VALUE, value)
            fragment.arguments = argument
            return fragment
        }
    }
}