package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentBB : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_b_b, container, false)
        v.findViewById<Button>(R.id.goToFragmentBA).setOnClickListener {
            val color = ColorGenerator.generateColor()
            parentFragmentManager.setFragmentResult("newColor", bundleOf("colorKey" to color))
            parentFragmentManager.popBackStack()
        }
        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentBB()
    }
}