package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResultListener
import otus.gpb.homework.fragments.databinding.FragmentBaBinding


class FragmentBA : Fragment(R.layout.fragment_ba) {

    private var fragmentBaBinding: FragmentBaBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBaBinding.bind(view)
        fragmentBaBinding = binding

        setFragmentResultListener("COLOR") { _, bundle ->
            val color = bundle.getInt("color")
            binding.firstFragment.setBackgroundColor(color)

        }

        val button: Button? = binding.openFragmentBb

        button?.setOnClickListener {
            parentFragmentManager.commit {
                replace<FragmentBB>(R.id.first_container)
                addToBackStack(null)
            }
        }
    }

    override fun onDestroyView() {
        fragmentBaBinding = null
        super.onDestroyView()
    }
}