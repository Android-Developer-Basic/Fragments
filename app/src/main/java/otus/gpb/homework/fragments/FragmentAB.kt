package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

private const val value = "Color"

class FragmentAB : Fragment(R.layout.fragment_ab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            view.setBackgroundColor(it.getInt(value))
        }
    }

    companion object {
        fun newInstance(color: Int) = FragmentAB().apply {
            arguments = Bundle().apply {
                putInt(value, color)
            }
        }
    }
}