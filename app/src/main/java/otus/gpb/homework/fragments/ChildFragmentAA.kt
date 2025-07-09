package otus.gpb.homework.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ChildFragmentAA : Fragment() {

    private var listener: ParentFragmentListener? = null
    private var backgroundColor: Int = Color.WHITE


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment is ParentFragmentListener) {
            listener = parentFragment as ParentFragmentListener
        } else {
            throw RuntimeException("${parentFragment} must implement ParentFragmentListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backgroundColor = it.getInt(ARG_BACKGROUND_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.child_fragment_aa, container, false)
        view.setBackgroundColor(backgroundColor)
        val openChildFragmentABButton: Button =
            view.findViewById(R.id.button_open_child_fragment_ab)
        openChildFragmentABButton.setOnClickListener {
            listener?.onOpenChildFragmentABClicked()
        }
        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        private const val ARG_BACKGROUND_COLOR = "background_color"

        fun newInstance(color: Int): ChildFragmentAA {
            val fragment = ChildFragmentAA()
            val args = Bundle().apply {
                putInt(ARG_BACKGROUND_COLOR, color)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
