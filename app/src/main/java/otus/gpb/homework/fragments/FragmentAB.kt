package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentAB : Fragment(R.layout.fragment_ab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(requireArguments().getInt(ARG_COLOR))
    }

    companion object {
        private const val ARG_COLOR = "color"

        fun newInstance(@ColorInt color: Int) = FragmentAB().apply {
            arguments = bundleOf(ARG_COLOR to color)
        }
    }
}
