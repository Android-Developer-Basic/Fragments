package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val BACKGROUND_COLOR = "backgroundColor"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAA : Fragment() {
    // TODO: Rename and change types of parameters
    private var backgroundColorParam: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backgroundColorParam = it.getInt(BACKGROUND_COLOR)
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
        view.setBackgroundColor(backgroundColorParam)

        view.findViewById<Button>(R.id.open_fragment_ab_btn).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.second_container, FragmentAB.newInstance(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment FragmentAA.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(backgroundColorParam: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(BACKGROUND_COLOR, backgroundColorParam)
                }
            }
    }
}