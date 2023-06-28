package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf


class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.findViewById<View>(R.id.button_return_color).setOnClickListener {
                val color = ColorGenerator.generateColor()
                parentFragmentManager.setFragmentResult("colorRequestKey", bundleOf("color" to color))
            }
        } else {
            view.findViewById<View>(R.id.button_return_color).setOnClickListener {
                val color = ColorGenerator.generateColor()
                parentFragmentManager.setFragmentResult("colorRequestKey", bundleOf("color" to color))
                parentFragmentManager.popBackStack()
            }
        }
    }
}