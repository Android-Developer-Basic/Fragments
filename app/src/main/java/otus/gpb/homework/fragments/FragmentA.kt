package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.open_fragment_aa_button).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_a_child_container,
                    FragmentAA.newInstance(ColorGenerator.generateColor()),
                    FRAGMENT_AA_TAG,
                )
                .addToBackStack(FRAGMENT_AA_TAG)
                .commit()
        }
    }

    private companion object {
        const val FRAGMENT_AA_TAG = "fragment_aa"
    }
}