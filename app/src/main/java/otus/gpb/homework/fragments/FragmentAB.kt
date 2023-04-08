package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes

private const val ARG_COLOR = "color"

class FragmentAB : Fragment() {
    @ColorRes
    private var color: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(ARG_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color?.let {
            view.setBackgroundColor(it)
        }
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentab_container, FragmentBA.newInstance())
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance(@ColorRes color: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLOR, color)
                }
            }
    }
}