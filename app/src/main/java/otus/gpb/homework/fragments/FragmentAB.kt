package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentAB : Fragment(R.layout.fragment_ab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            try {
                view.setBackgroundColor(requireArguments().getInt("color"))
            } catch (e: IllegalStateException) {
                Toast.makeText(this.context, "Fragment AB: No arguments passed", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
