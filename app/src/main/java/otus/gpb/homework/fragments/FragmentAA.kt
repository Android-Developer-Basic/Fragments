package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setBackgroundColor(requireArguments().getInt(ARG_COLOR))

        view.findViewById<Button>(R.id.buttonOpenFragmentAB).setOnClickListener {
            // FragmentAA сам является ребёнком FragmentA, поэтому его parentFragmentManager —
            // это childFragmentManager фрагмента A. Так FragmentAB тоже становится ребёнком A.
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.child_fragment_container,
                    FragmentAB.newInstance(ColorGenerator.generateColor())
                )
                addToBackStack(null)
            }
        }
    }

    companion object {
        private const val ARG_COLOR = "color"

        fun newInstance(@ColorInt color: Int) = FragmentAA().apply {
            arguments = bundleOf(ARG_COLOR to color)
        }
    }
}
