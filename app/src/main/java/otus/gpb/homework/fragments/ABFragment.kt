package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentAbBinding

class ABFragment : Fragment() {

    private lateinit var binding: FragmentAbBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAbBinding.inflate(inflater, container, false)
        val color = arguments?.getInt(COLOR_KEY) ?: Color.WHITE
        binding.layout.setBackgroundColor(color)
        return binding.root
    }

    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
        fun newInstance(color: Int) = ABFragment().apply {
            arguments = Bundle().apply {
                putInt(COLOR_KEY, color)
            }
        }
    }

}