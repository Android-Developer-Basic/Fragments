package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import otus.gpb.homework.fragments.databinding.FragmentAbBinding


private const val COLOR = "COLOR"

class FragmentAB : Fragment(R.layout.fragment_ab) {

    private var fragmentAbBinding: FragmentAbBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAbBinding.bind(view)
        fragmentAbBinding = binding

        arguments?.let {
            binding.abFragment
                .setBackgroundColor(it.getInt(COLOR))
        }
    }

    override fun onDestroyView() {
        fragmentAbBinding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(COLOR, color)
                }
            }
    }
}