package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResultListener


class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("KEY") { _, bundle ->
            val color = bundle.getInt("color")
            view.findViewById<ConstraintLayout>(R.id.first_fragment).setBackgroundColor(color)
        }

        val button: Button? = view.findViewById(R.id.open_fragment_bb)

        button?.setOnClickListener {
            parentFragmentManager.commit {
                replace<FragmentBB>(R.id.first_container)
                addToBackStack(null)
            }
        }
    }
}