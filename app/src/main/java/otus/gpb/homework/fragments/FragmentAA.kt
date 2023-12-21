package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentAABinding

class FragmentAA : Fragment(R.layout.fragment_a_a) {
    // TODO: Rename and change types of parameters
    private var paramColor: Int = Color.WHITE

    private lateinit var binding: FragmentAABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramColor = it.getInt(ColorGenerator.ARG_COLOR)
        }
        binding = FragmentAABinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAABinding.inflate(inflater, container, false)

        binding.frameLayoutFragmentAA.setBackgroundColor(paramColor)
        binding.buttonOpenFragmentAB.setOnClickListener {  }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(paramColor: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(ColorGenerator.ARG_COLOR, paramColor)
                }
            }
    }
}