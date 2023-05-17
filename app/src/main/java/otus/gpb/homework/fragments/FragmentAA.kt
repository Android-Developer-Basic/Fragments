package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatButton>(R.id.button_open_fragment_ab)?.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_frame_aa, FragmentAB())
                .addToBackStack(null)
                .commit()
            Log.d("app", "fragment_aa")
        }
    }
}