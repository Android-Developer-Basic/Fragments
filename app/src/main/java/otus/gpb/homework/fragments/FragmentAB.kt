package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_BCK_COLOR = "background_color"

class FragmentAB : Fragment() {
    private var backgroundColor: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backgroundColor = it.getInt(ARG_BCK_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backgroundColor?.let { backgroundColor -> view.setBackgroundColor(backgroundColor) }
    }

    companion object {
        @JvmStatic
        fun newInstance(bckColor: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(ARG_BCK_COLOR, bckColor)
                }
            }
    }
}