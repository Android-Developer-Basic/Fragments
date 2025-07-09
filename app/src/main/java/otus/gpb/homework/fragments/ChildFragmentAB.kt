package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ChildFragmentAB : Fragment() {

    private var backgroundColor: Int = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backgroundColor = it.getInt(ARG_BACKGROUND_COLOR, Color.WHITE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.child_fragment_ab, container, false)
        view?.setBackgroundColor(backgroundColor)
        return view
    }

    companion object {
        private const val ARG_BACKGROUND_COLOR = "background_color_ab"

        fun newInstance(color: Int): ChildFragmentAB {
            val fragment = ChildFragmentAB()
            val args = Bundle().apply {
                putInt(ARG_BACKGROUND_COLOR, color)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
