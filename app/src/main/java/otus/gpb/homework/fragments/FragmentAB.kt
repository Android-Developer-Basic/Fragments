package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentAABinding
import otus.gpb.homework.fragments.databinding.FragmentABBinding

class FragmentAB : Fragment(R.layout.fragment_a_b) {
    // TODO: Rename and change types of parameters
    private var paramColor: Int = Color.WHITE

    private lateinit var binding: FragmentABBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramColor = it.getInt(ColorGenerator.ARG_COLOR)
        }
        binding = FragmentABBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABBinding.inflate(inflater, container, false)

        binding.frameLayoutFragmentAB.setBackgroundColor(paramColor)

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(paramColor: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(ColorGenerator.ARG_COLOR, paramColor)
                }
            }
    }

}