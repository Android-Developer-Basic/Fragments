package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

private const val COLOR_ARG = "color_arg"

class FragmentAA : Fragment() {

    private fun getBackgroundColor() = arguments?.getInt(COLOR_ARG) ?: Color.WHITE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(getBackgroundColor())
        view.findViewById<MaterialButton>(R.id.fragment_ab_btn).setOnClickListener {
            (parentFragment as FragmentA).createFragmentAB()
        }
    }

    companion object {
        fun newInstance(color: Int): FragmentAA {
            fun setBundleArgument() = Bundle().apply { putInt(COLOR_ARG, color) }
            return FragmentAA().apply {
                arguments = setBundleArgument()
            }
        }
    }
}