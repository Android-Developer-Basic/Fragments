package otus.gpb.homework.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
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
            view.rootView.findViewById<FrameLayout>(R.id.container)
                .setBackgroundColor(it.getInt(value))
        }
        view.findViewById<Button>(R.id.b_open_fr_ab).setOnClickListener {
            val color = ColorGenerator.generateColor()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentAB.newInstance(color), "fragment_ab")
                .addToBackStack(null)
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

}