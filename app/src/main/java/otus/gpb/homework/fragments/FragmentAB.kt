package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val COLOR_ARG = "color_arg"

class FragmentAB : Fragment() {

    private fun getBackgroundColor() = arguments?.getInt(COLOR_ARG) ?: Color.WHITE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(getBackgroundColor())
    }

    companion object {
        fun newInstance(color: Int): FragmentAB {
            fun setBundleArgument () = Bundle().apply { putInt(COLOR_ARG, color) }
            return FragmentAB().apply {
                arguments = setBundleArgument()
            }
        }
    }
}