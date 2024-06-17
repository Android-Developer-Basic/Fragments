package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentBB : Fragment(R.layout.fragment_bb) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(requireArguments().getInt(KEY_COLOR))
        view.findViewById<Button>(R.id.buttonBA)?.setOnClickListener {
            with(parentFragmentManager) {
                setFragmentResult(KEY_COLOR, bundleOf(KEY_COLOR to ColorGenerator.generateColor()))
                popBackStack()
            }
        }
    }
}