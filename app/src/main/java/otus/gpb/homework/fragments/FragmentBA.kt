package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val backColor = arguments?.getInt(BACK_COLOR)
        if (backColor != null) {
            view.setBackgroundColor(backColor)
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            view.findViewById<Button>(R.id.button).setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container_b,
                        FragmentBB()
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
        parentFragmentManager.setFragmentResultListener(FRAGMENT_BB_RESULT, this) { _, res ->
            val color = res.getInt(BACK_COLOR)
            arguments?.putInt(BACK_COLOR, color)
            view.setBackgroundColor(color)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(color: Int) =
            FragmentBA().apply {
                arguments = Bundle().apply {
                    putInt(BACK_COLOR, color)
                }
            }
    }
}