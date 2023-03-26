package otus.gpb.homework.fragments.taskA

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentAA : Fragment(R.layout.fragment_a_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorBackground = arguments?.getInt(ARG_VALUE)
        if (colorBackground != null) {
            view.setBackgroundColor(colorBackground)
        }

        view.findViewById<Button>(R.id.open_fragment_a_b).setOnClickListener {

            parentFragment?.also {
                it.childFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.child_container_a,
                        FragmentAB.create(ColorGenerator.generateColor())
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {

        private const val ARG_VALUE = "color_background"

        fun create(value: Int): FragmentAA {
            val fragment = FragmentAA()
            val argument = Bundle()
            argument.putInt(ARG_VALUE, value)
            fragment.arguments = argument
            return fragment
        }
    }
}