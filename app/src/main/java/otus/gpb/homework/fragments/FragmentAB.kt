package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAB : Fragment(R.layout.fragment_a_b) {
    companion object {
        private const val KEY_COLOR = "key_color"
        fun create(color: Int): FragmentAB {
            val fragment = FragmentAB()
            val arguments = Bundle()
            arguments.putInt(KEY_COLOR, color)
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = arguments?.getInt(KEY_COLOR)
        color?.let { view.setBackgroundColor(color) }
    }
}