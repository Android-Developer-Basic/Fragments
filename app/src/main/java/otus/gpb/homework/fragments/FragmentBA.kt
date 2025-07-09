package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA : Fragment() {

    private var backgroundColor: Int = Color.WHITE
    private lateinit var openFragmentBBButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backgroundColor = it.getInt(ARG_BACKGROUND_COLOR, Color.WHITE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_ba,
            container,
            false
        )
        view.setBackgroundColor(backgroundColor)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(
            ActivityB.REQUEST_KEY_COLOR,
            viewLifecycleOwner
        ) { requestKey, bundle ->
            if (requestKey == ActivityB.REQUEST_KEY_COLOR) {
                val newColor = bundle.getInt(ActivityB.BUNDLE_KEY_COLOR, Color.WHITE)
                view.setBackgroundColor(newColor)
                this.backgroundColor = newColor
            }
        }

        openFragmentBBButton = view.findViewById(R.id.button_open_fragment_bb)

        val currentOrientation = resources.configuration.orientation
        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            openFragmentBBButton.visibility = View.VISIBLE
            openFragmentBBButton.setOnClickListener {
                openFragmentBBInPortrait()
            }
        } else {
            openFragmentBBButton.visibility = View.GONE
        }
    }

    private fun openFragmentBBInPortrait() {
        val randomColor = ColorGenerator.generateColor()
        val fragmentBB = FragmentBB.newInstance(randomColor)

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_b_activity_container, fragmentBB)
            .addToBackStack("FragmentBBFromBA")
            .commit()
    }

    companion object {
        private const val ARG_BACKGROUND_COLOR = "background_color_ba"

        fun newInstance(color: Int): FragmentBA {
            val fragment = FragmentBA()
            val args = Bundle().apply {
                putInt(ARG_BACKGROUND_COLOR, color)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
