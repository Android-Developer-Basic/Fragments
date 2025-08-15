package otus.gpb.homework.fragments

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf

const val RESULT_KEY = "RESULT_KEY"
const val RESULT_BUNDLE_KEY = "RESULT_BUNDLE_KEY"
/**
 * A simple [Fragment] subclass.
 * Use the [FragmentBA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentBA : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        view.findViewById<Button>(R.id.buttonOpenBB).setOnClickListener {
            if (savedInstanceState == null) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentBB(), "FragmentBB")
                    .addToBackStack(null)
                    .commit()
            }
        }
        parentFragmentManager.setFragmentResultListener(RESULT_KEY, this) { _, bundle ->
            val color = bundle.getInt(RESULT_BUNDLE_KEY)
            val v = view.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.fragmentBA)
            v.setBackgroundColor(color)
        }
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val bt = view.findViewById<Button>(R.id.buttonOpenBB)
            bt.visibility = View.GONE
        }
    }
}