package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import otus.gpb.homework.fragments.databinding.FragmentBBBinding

class FragmentBB : Fragment(R.layout.fragment_b_b) {

    private lateinit var binding: FragmentBBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentBBBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBBinding.inflate(inflater, container, false)

        binding.buttonSendColor.setOnClickListener {
            val color = ColorGenerator.generateColor()
            parentFragmentManager.setFragmentResult(ColorGenerator.ARG_COLOR_REQUEST, bundleOf(ColorGenerator.ARG_COLOR to color))

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                parentFragmentManager.popBackStack()
            }
        }

        return binding.root
    }
}