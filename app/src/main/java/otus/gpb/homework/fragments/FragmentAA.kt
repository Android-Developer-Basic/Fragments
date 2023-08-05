package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_a_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.open_ab_button).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_a, FragmentAB.create(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
        }
        val color = arguments?.getInt(COLOR)
        color?.let { view.setBackgroundColor(color) }
    }

    companion object {

        private const val COLOR = "color"

        fun create(color: Int): FragmentAA {
            val fragment = FragmentAA()
            val arguments = Bundle()
            arguments.putInt(COLOR, color)
            fragment.arguments = arguments
            return fragment
        }
    }
}