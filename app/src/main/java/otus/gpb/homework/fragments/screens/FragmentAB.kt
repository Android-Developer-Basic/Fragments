package otus.gpb.homework.fragments.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.KEY_COLOR
import otus.gpb.homework.fragments.R

class FragmentAB : Fragment(R.layout.fragment_ab) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.fragment_ab)

        view.setBackgroundColor(requireArguments().getInt(KEY_COLOR))
    }
}