package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.addCallback
import otus.gpb.homework.fragments.databinding.FragmentABinding


class FragmentA : Fragment(R.layout.fragment_a) {
    private var fragmentABinding: FragmentABinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentABinding.bind(view)
        fragmentABinding = binding
        binding.openFragmentAa.setOnClickListener {

            val color = ColorGenerator.generateColor()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_a_container, FragmentAA.newInstance(color))
                .addToBackStack(null)
                .commit()
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            val count = parentFragmentManager.backStackEntryCount

            if (count > 1)
                parentFragmentManager.popBackStack()
            else
                requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        fragmentABinding = null
        super.onDestroyView()
    }
}