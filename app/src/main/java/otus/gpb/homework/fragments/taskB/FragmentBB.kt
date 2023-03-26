package otus.gpb.homework.fragments.taskB

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentBB : Fragment(R.layout.fragment_b_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.send_color).setOnClickListener {
            val result = Bundle()
            result.putInt("color", ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult("color_from_bb", result)
        }
    }
}