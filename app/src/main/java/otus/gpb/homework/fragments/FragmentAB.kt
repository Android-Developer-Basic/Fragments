package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

private const val value = "COLOR"

class FragmentAB : Fragment(R.layout.fragment_ab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            view.rootView.findViewById<FrameLayout>(R.id.fragment_container)
                .setBackgroundColor(it.getInt(value))
        }
    }

    companion object {

        @JvmStatic
        fun newInst(color: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(value, color)
                }
            }
    }
}