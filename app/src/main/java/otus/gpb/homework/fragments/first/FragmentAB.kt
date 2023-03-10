package otus.gpb.homework.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
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
            view.findViewById<ConstraintLayout>(R.id.fragment_ab)
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


