package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.databinding.FragmentAABinding
import otus.gpb.homework.fragments.databinding.FragmentBABinding

private const val BACKGROUND_COLOR = "background_color"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentBA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentBA : Fragment(), ButtonController {

    private var backGroundColor: Int? = null
    private lateinit var container: FrameLayout

    private var clickListener: ButtonFragmentOnClickListener? = null

    interface ButtonFragmentOnClickListener {
        fun setButtonFragmentOnClickListener(button: Button)
    }

    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        parentFragment?.let {
            if (it is ButtonFragmentOnClickListener) {
                clickListener = it
            }
        }
    }

    private var _binding: FragmentBABinding? = null
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        backGroundColor?.let {
            outState.putInt(BACKGROUND_COLOR, it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backGroundColor?.let { view.setBackgroundColor(it) }

        container = view as FrameLayout


        parentFragmentManager.setFragmentResultListener("color", this) { _, bundle ->
            backGroundColor = bundle.getInt("color")
            view.setBackgroundColor(backGroundColor!!)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentBA.
         */
        @JvmStatic
        fun newInstance(backGroundColor: Int) =
            FragmentBA().apply {
                arguments = Bundle().apply {
                    putInt(BACKGROUND_COLOR, backGroundColor)
                }
            }
    }

    override fun addButton(isActive: Boolean) {
        val button = layoutInflater.inflate(R.layout.button_for_fragment_ba, container, false) as Button
        button.isEnabled = isActive
        button.setOnClickListener {
            clickListener?.setButtonFragmentOnClickListener(button)
        }
        container.addView(button)
    }

}