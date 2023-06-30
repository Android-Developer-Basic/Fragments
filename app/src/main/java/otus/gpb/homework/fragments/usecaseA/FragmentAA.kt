package otus.gpb.homework.fragments.usecaseA

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentAA() : Fragment(R.layout.fragment_aa) {
    companion object {
        private const val COLOR = "color"

        fun create(value: Int): FragmentAA {
            val fragment = FragmentAA()
            val arguments = Bundle()
            arguments.putInt(COLOR, value)
            fragment.arguments = arguments
            return fragment
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(this@FragmentAA.context, "FragmentAA", Toast.LENGTH_SHORT).show()

        arguments?.getInt(COLOR)?.let {
            view.findViewById<FrameLayout>(R.id.fragment_frame_aa)?.setBackgroundColor(it)
        }

        view.findViewById<AppCompatButton>(R.id.button_open_fragment_ab)?.setOnClickListener {
            parentFragment?.childFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_frame_a, FragmentAB.create(ColorGenerator.generateColor()))
                ?.addToBackStack(null)
                ?.commit()
            Log.d("app", "clicked button to open fragment_ab")
        }
    }
}