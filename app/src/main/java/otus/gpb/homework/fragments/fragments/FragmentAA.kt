package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.jetbrains.annotations.NotNull
import otus.gpb.homework.fragments.COLOR_PARAM
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAA : Fragment() {
    // TODO: Rename and change types of parameters
    private var background by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            background = it.getInt(COLOR_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_a_a, container, false)
        v.findViewById<Button>(R.id.goToFragmentAB).setOnClickListener {
            val color = ColorGenerator.generateColor()
            val fAB = FragmentAB.newInstance(color)
            parentFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentContainer, fAB).commit()
        }
        v.setBackgroundColor(background);
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentAA.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(color: Int) = FragmentAA().apply {
            arguments = Bundle().apply {
                putInt(COLOR_PARAM, color)
            }
        }
    }
}