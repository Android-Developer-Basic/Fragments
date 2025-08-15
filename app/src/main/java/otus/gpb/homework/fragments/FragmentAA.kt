package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val ARG_COLOR = "color"

class FragmentAA : Fragment() {
    private var color: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(ARG_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            if (savedInstanceState == null) {
                val color = ColorGenerator.generateColor()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_a_container, FragmentAB.newInstance(color), "FragmentAB")
                    .addToBackStack(null)
                    .commit()
            }
        }
        val v = view.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.fragment_a_a)
        if (color != null)
            v.setBackgroundColor(color!!)
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLOR, color)
                }
            }
    }
}