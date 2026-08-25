package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentAB : Fragment(R.layout.fragment_ab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(requireArguments().getInt(ARG_COLOR))
    }

    companion object {
        private const val ARG_COLOR = "color"

        fun newInstance(color: Int) = FragmentAB().apply {
            arguments = Bundle().apply { putInt(ARG_COLOR, color) }
        }
    }
}