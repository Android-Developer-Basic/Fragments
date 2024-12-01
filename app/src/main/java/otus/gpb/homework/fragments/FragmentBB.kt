package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentBB : Fragment(R.layout.fragment_bb) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ColorGenerator.generateColor())

        view.findViewById<Button>(R.id.button_send_color).setOnClickListener {
            parentFragmentManager.setFragmentResult("send2BA", bundleOf("color" to ColorGenerator.generateColor()))
        }
    }
}
