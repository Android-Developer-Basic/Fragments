package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val SET_COLOR = "setColor"

class FragmentAB : Fragment() {
    private var color: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(SET_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(color)
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(SET_COLOR, color)
                }
            }
    }
}