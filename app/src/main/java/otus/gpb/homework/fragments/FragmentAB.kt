package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout


private const val KEY = "COLOR"

class FragmentAB : Fragment(R.layout.fragment_ab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            view.findViewById<ConstraintLayout>(R.id.ab_fragment)
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