package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAB : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { view.setBackgroundColor(it.getInt(COLOR)) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_b, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val count1 = parentFragmentManager.backStackEntryCount
                val count2 = childFragmentManager.backStackEntryCount
                if (parentFragmentManager.backStackEntryCount > 0) {
                    parentFragmentManager.popBackStack()
                }
                else {
                    isEnabled = false
                    parentFragmentManager.beginTransaction().remove(this@FragmentAB).commitAllowingStateLoss()
                }
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    companion object {
        private const val COLOR = "color"

        fun withArgs(value: Int) : FragmentAB {
            val fragment = FragmentAB()
            val arguments = Bundle()
            arguments.putInt(COLOR, value)
            fragment.arguments = arguments
            return  fragment
        }
    }
}