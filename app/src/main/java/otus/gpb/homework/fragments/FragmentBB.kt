package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bb, container, false)
        view.setBackgroundColor(Color.YELLOW)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val changeColorButton: Button = view.findViewById(R.id.button_send_color)
        changeColorButton.setOnClickListener {
            val newColor = ColorGenerator.generateColor()
            val result = Bundle().apply {
                putInt(ActivityB.BUNDLE_KEY_COLOR, newColor)
            }
            parentFragmentManager.setFragmentResult(ActivityB.REQUEST_KEY_COLOR, result)

            val currentOrientation = resources.configuration.orientation
            if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.popBackStack()

            }
        }
    }

    companion object {
        private const val ARG_BACKGROUND_COLOR = "background_color_bb"

        fun newInstance(color: Int): FragmentBB {
            val fragment = FragmentBB()
            val args = Bundle().apply {
                putInt(ARG_BACKGROUND_COLOR, color)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
