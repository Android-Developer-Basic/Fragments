package otus.gpb.homework.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ColorGenerator.generateColor())

        if (activity?.findViewById<FragmentContainerView>(R.id.fragment_BA) != null) {
            view.findViewById<Button>(R.id.button_open_frgBB).isVisible = false
        }

        if (activity?.findViewById<FrameLayout>(R.id.fragment_container) != null) {
            view.findViewById<Button>(R.id.button_open_frgBB).setOnClickListener {

                val key = "FragmentBB"
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, FragmentBB(), key)
                    .addToBackStack(key)
                    .commit()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("send2BA", this) { _, bundle ->
            view?.setBackgroundColor(bundle.getInt("color"))
        }
    }

}
