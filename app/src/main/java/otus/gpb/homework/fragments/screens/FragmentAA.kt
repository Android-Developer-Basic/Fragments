package otus.gpb.homework.fragments.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.KEY_COLOR
import otus.gpb.homework.fragments.R

class FragmentAA : Fragment(R.layout.fragment_aa) {

    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.fragment_aa)

        view.setBackgroundColor(requireArguments().getInt(KEY_COLOR))
        button = view.findViewById(R.id.button_ab)
        button.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, FragmentAB().apply {
                    arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor())
                })
                .addToBackStack(null)
                .commit()
        }
    }
}