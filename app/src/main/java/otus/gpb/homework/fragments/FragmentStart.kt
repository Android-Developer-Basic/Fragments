package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import otus.gpb.homework.fragments.databinding.FragmentStartBinding


class FragmentStart : Fragment(R.layout.fragment_start) {

    private var fragmentStartBinding: FragmentStartBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentStartBinding.bind(view)
        fragmentStartBinding = binding
        binding.openFragmentA.setOnClickListener {

            parentFragmentManager.commit {
                replace<FragmentA>(R.id.fragment_container)
            }
        }
    }


    override fun onDestroyView() {
        fragmentStartBinding = null
        super.onDestroyView()
    }

}