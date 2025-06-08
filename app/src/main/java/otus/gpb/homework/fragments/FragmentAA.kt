package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentAABinding

private const val BACKGROUND_COLOR = "background_color"


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAA : Fragment() {

    private var _binding: FragmentAABinding? = null
    private val binding get() = _binding!!
    private var backGroundColor: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backGroundColor = it.getInt(BACKGROUND_COLOR)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backGroundColor?.let { view.setBackgroundColor(backGroundColor!!) }
        binding.btnOpenFragmentAB.setOnClickListener {
            val backgroundColor = ColorGenerator.generateColor()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerA, FragmentAB.newInstance(backgroundColor), "AB")
                .addToBackStack(null)
                .commit()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAABinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(backGroundColor: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(BACKGROUND_COLOR, backGroundColor)
                }
            }
    }
}