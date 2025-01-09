package otus.gpb.homework.fragments

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.os.bundleOf

class FragmentBB : Fragment() {
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.button_color)
        if (resources.configuration.orientation == ORIENTATION_PORTRAIT) {
            requireActivity().findViewById<FrameLayout>(R.id.container_ba).visibility = GONE
            requireActivity().findViewById<FrameLayout>(R.id.container_bb).visibility = VISIBLE
        }
        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_ba, FragmentBA().apply {
                    arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor())
                })
                .commit()
        }
    }
}