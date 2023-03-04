package otus.gpb.homework.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

private const val value = "Color"

class FragmentAB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            view.rootView.findViewById<FrameLayout>(R.id.container)
            .setBackgroundColor(it.getInt(value))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) = FragmentAB().apply {
            arguments = Bundle().apply {
                putInt(value, color)
            }
        }
    }

}


