package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment(R.layout.fragment_bb) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnGenerate = view.findViewById<Button>(R.id.btnGenerateColor)

        btnGenerate.setOnClickListener {
            val color = ColorGenerator.generateColor()
            val result = Bundle().apply { putInt("color_result", color) }

            parentFragmentManager.setFragmentResult("color_request", result)

            if (activity?.findViewById<View>(R.id.container_b) != null) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}