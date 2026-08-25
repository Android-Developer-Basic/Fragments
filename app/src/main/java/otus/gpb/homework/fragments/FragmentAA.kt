package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(requireArguments().getInt(ARG_COLOR))

        view.findViewById<View>(R.id.open_fragment_ab_button).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_a_child_container,
                    FragmentAB.newInstance(ColorGenerator.generateColor()),
                    FRAGMENT_AB_TAG,
                )
                .addToBackStack(FRAGMENT_AB_TAG)
                .commit()
        }
    }

    companion object {
        private const val ARG_COLOR = "color"
        private const val FRAGMENT_AB_TAG = "fragment_ab"

        fun newInstance(color: Int) = FragmentAA().apply {
            arguments = Bundle().apply { putInt(ARG_COLOR, color) }
        }
    }
}