package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult


class FragmentBB : Fragment(R.layout.fragment_bb) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.send).setOnClickListener {
            val color = ColorGenerator.generateColor()

            setFragmentResult("KEY", bundleOf("color" to color))
        }
    }
}
