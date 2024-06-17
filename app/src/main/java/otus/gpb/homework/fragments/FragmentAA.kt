package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_aa) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(requireArguments().getInt(KEY_COLOR))
        view.findViewById<Button>(R.id.buttonAB)?.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .add(R.id.container, FragmentAB().apply { arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor()) })
                .addToBackStack(null)
                .commit()
        }
    }
}