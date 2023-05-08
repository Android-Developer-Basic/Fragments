package otus.prokofev.homework.fragments.one

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import otus.prokofev.homework.fragments.R

class MainFragment : Fragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.b_open_fr_a).setOnClickListener {

            parentFragmentManager.commit {
                replace<FragmentA>(R.id.container)
            }
        }
    }

}
