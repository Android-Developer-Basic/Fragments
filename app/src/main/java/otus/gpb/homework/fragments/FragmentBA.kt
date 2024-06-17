package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentBA : Fragment(R.layout.fragment_ba) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(KEY_COLOR, viewLifecycleOwner) { key, bundle ->
            if (key == KEY_COLOR)
                view.setBackgroundColor(bundle.getInt(key))
        }
        view.setBackgroundColor(requireArguments().getInt(KEY_COLOR))
        view.findViewById<Button>(R.id.buttonBB)?.run {
            if (requireActivity().findViewById<LinearLayout>(R.id.layout).orientation == LinearLayout.VERTICAL) {
                visibility = VISIBLE
                setOnClickListener {
                    parentFragmentManager
                        .beginTransaction()
                        .add(R.id.container, FragmentBB().apply { arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor()) })
                        .addToBackStack(null)
                        .commit()
                }
            } else
                visibility = GONE

        }
    }
}