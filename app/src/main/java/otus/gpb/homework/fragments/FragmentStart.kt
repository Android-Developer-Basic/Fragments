package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace



class FragmentStart : Fragment(R.layout.fragment_start) {

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.open_fragment_a).setOnClickListener {

            parentFragmentManager.commit {
                replace<FragmentA>(R.id.fragment_container)
            }
        }
    }
}