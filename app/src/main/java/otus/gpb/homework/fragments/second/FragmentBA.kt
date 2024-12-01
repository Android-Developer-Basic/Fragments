package otus.gpb.homework.fragments.second

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResultListener
import otus.gpb.homework.fragments.R

class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.b_open_fr_bb).setOnClickListener {

            parentFragmentManager.commit {
                replace<FragmentBB>(R.id.container_one)

            }
        }

        setFragmentResultListener("key") { _, bundle ->
            val color = bundle.getInt("color")
            view.findViewById<ConstraintLayout>(R.id.container_one)
                .setBackgroundColor(color)
        }
    }
}