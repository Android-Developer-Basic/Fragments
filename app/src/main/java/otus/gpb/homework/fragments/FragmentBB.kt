package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import otus.gpb.homework.fragments.databinding.FragmentAABinding
import otus.gpb.homework.fragments.databinding.FragmentBBBinding


private const val BACKGROUND_COLOR = "background_color"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentBB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentBB : Fragment() {


    private var backGroundColor: Int? = null

    private var _binding: FragmentBBBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backGroundColor = it.getInt(BACKGROUND_COLOR)
        }

        savedInstanceState?.let {
            backGroundColor = it.getInt(BACKGROUND_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backGroundColor?.let { view.setBackgroundColor(it) }

        view.findViewById<Button>(R.id.btn_send_color).setOnClickListener {
            parentFragmentManager.setFragmentResult("color", bundleOf("color" to backGroundColor))
            backGroundColor = ColorGenerator.generateColor()
            view.setBackgroundColor(backGroundColor!!)
            parentFragmentManager.popBackStack()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        backGroundColor?.let {
            outState.putInt(BACKGROUND_COLOR, it)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentBB.
         */
        @JvmStatic
        fun newInstance(backGroundColor: Int) =
            FragmentBB().apply {
                arguments = Bundle().apply {
                    putInt(BACKGROUND_COLOR, backGroundColor)
                }
            }
    }
}