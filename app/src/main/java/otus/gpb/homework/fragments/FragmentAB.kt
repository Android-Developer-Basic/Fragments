package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.FrameLayout

private const val KEY = "COLOR"

class FragmentAB : Fragment(R.layout.fragment_a_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            view.rootView.findViewById<FrameLayout>(R.id.child_fragment_container)
                .setBackgroundColor(it.getInt(KEY))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(KEY, color)
                }
            }
    }
}
