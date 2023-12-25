package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import otus.gpb.homework.fragments.COLOR_PARAM
import otus.gpb.homework.fragments.R
import kotlin.properties.Delegates

class FragmentBA : Fragment() {
    private var color by Delegates.notNull<Int>()
    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(COLOR_PARAM)
        }
        parentFragmentManager.setFragmentResultListener("newColor", this) { requestKey, bundle ->
            color = bundle.getInt("colorKey")
            view.setBackgroundColor(color)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_b_a, container, false)
        view.setBackgroundColor(color)
        view.findViewById<Button>(R.id.openFragmentBB).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentContainer, FragmentBB.newInstance())
                .commit()
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            FragmentBA().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_PARAM, color)
                }
            }
    }
}