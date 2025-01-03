package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.setFragmentResultListener

class FragmentAB : Fragment(R.layout.fragment_ab) {

    private var color: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(savedInstanceState != null) {
            color = savedInstanceState.getInt("color")
        } else {
            color = getArguments()?.getInt("colorToFragmentAB")
        }
        color?.let{view.setBackgroundColor(it)}
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        color?.let{ outState.putInt("color", it) }
    }
}