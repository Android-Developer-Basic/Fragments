package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

private const val value = "COLOR"

class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            view.rootView.findViewById<FrameLayout>(R.id.fragment_container)
                .setBackgroundColor(it.getInt(value))
        }

        view.findViewById<Button>(R.id.go_to_fragment_AB).setOnClickListener {
            val color = ColorGenerator.generateColor()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentAB.newInst(color))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInst(color: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(value, color)
                }
            }
    }
}
