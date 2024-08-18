package otus.gpb.homework.fragments.screens

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.KEY_COLOR
import otus.gpb.homework.fragments.R

class FragmentBA : Fragment(R.layout.fragment_ba) {

    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val orientation = resources.configuration.orientation
        view.setBackgroundColor(requireArguments().getInt(KEY_COLOR))

        button = view.findViewById(R.id.button_bb)
        if (orientation == ORIENTATION_PORTRAIT) {
            requireActivity().findViewById<FrameLayout>(R.id.container_ba).visibility = VISIBLE
            requireActivity().findViewById<FrameLayout>(R.id.container_bb).visibility = GONE
            button.visibility = VISIBLE
            button.setOnClickListener {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_bb, FragmentBB())
                    .commit()
            }
        } else if (orientation == ORIENTATION_LANDSCAPE) {
            button.visibility = GONE
        }
    }
}