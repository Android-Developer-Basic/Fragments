package otus.gpb.homework.fragments.first

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

private const val value = "Color"

class FragmentAA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            view.findViewById<ConstraintLayout>(R.id.fragmentAA)
                .setBackgroundColor(it.getInt(value))
        }
        view.findViewById<Button>(R.id.b_open_fr_ab).setOnClickListener {
            val color = ColorGenerator.generateColor()
            childFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .replace(R.id.childFragment, FragmentAB.newInstance(color))
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) = FragmentAA().apply {
            arguments = Bundle().apply {
                putInt(value, color)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentFragmentManager.commit {
            setPrimaryNavigationFragment(this@FragmentAA)
        }
    }

}