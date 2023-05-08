package otus.prokofev.homework.fragments.two

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import otus.prokofev.homework.fragments.ColorGenerator
import otus.prokofev.homework.fragments.R

class FragmentBB : Fragment(R.layout.fragment_bb) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.b_send_color).setOnClickListener {
            val color = ColorGenerator.generateColor()
            setFragmentResult("key", bundleOf("color" to color))

        }

    }

}