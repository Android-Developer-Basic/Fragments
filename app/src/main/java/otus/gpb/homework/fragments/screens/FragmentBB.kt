package otus.gpb.homework.fragments.screens

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.KEY_COLOR
import otus.gpb.homework.fragments.R

class FragmentBB : Fragment(R.layout.fragment_bb) {

    private lateinit var button: Button

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