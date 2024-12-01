package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_aa) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.showFragmentAB).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerAA, FragmentAB.create(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
        }
        val color = arguments?.getInt(ARG_COLOR)
        color?.let { (view.setBackgroundColor(color))}
    }

    companion object {
        private const val ARG_COLOR = "color"

        fun create(value: Int) : FragmentAA {
            val fragment = FragmentAA()
            val arguments = Bundle()
            arguments.putInt(ARG_COLOR, value)
            fragment.arguments = arguments
            return  fragment
        }
    }

}