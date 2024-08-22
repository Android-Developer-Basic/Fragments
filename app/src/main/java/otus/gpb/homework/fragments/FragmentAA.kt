package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


private const val KEY_COLOR = "color"


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAA : Fragment() {

    private var color: Int? = null
    private lateinit var buttonOpenFragmentAB: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(KEY_COLOR)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorHex = color
        if (colorHex != null) {
            view.setBackgroundColor(colorHex)
        }

        buttonOpenFragmentAB = view.findViewById(R.id.buttonOpenFragmentAB)
        buttonOpenFragmentAB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_aa, FragmentAA.newInstance(ColorGenerator.generateColor()))
                .addToBackStack("fragmentA")
                .commit()
            buttonOpenFragmentAB.visibility = View.GONE
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (parentFragmentManager.backStackEntryCount > 0) {
                    parentFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    parentFragmentManager.beginTransaction().remove(this@FragmentAA)
                        .commitAllowingStateLoss()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param color Parameter 1.
         * @return A new instance of fragment FragmentAA.
         */

        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(KEY_COLOR, color)
                }
            }
    }
}