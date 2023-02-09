package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.databinding.FragmentBbBinding


class FragmentBB : Fragment(R.layout.fragment_bb) {

    private var fragmentBbBinding: FragmentBbBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBbBinding.bind(view)
        fragmentBbBinding = binding
        binding.send.setOnClickListener {

            val color = ColorGenerator.generateColor()

            setFragmentResult("COLOR", bundleOf("color" to color))
        }

    }

    override fun onDestroyView() {
        fragmentBbBinding = null
        super.onDestroyView()
    }
}
