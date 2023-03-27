package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val BACKGROUND_COLOR = "backgroundColor"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentBA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentBA : Fragment() {
    // TODO: Rename and change types of parameters
    private var backgroundColor : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backgroundColor = it.getInt(BACKGROUND_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(backgroundColor)

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            view.findViewById<Button>(R.id.open_fragment_bb_btn).setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_first_container, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }

        parentFragmentManager.setFragmentResultListener("bb_result", this){_, result->
            backgroundColor = result.getInt("color")
            view.setBackgroundColor(backgroundColor)
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
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(backgroundColor: Int) =
            FragmentBA().apply {
                arguments = Bundle().apply {
                    putInt(BACKGROUND_COLOR, backgroundColor)
                }
            }
    }
}