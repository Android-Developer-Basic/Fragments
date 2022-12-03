package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.FrameLayout

private const val KEY = "COLOR"

class FragmentAA : Fragment(R.layout.fragment_a_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            view.rootView.findViewById<FrameLayout>(R.id.child_fragment_container)
                .setBackgroundColor(it.getInt(KEY))
        }

        view.findViewById<Button>(R.id.go_to_fragment_AB).setOnClickListener {
            val color = ColorGenerator.generateColor()

            parentFragmentManager.beginTransaction()
                .replace(R.id.child_fragment_container, FragmentAB.newInstance(color))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(KEY, color)
                }
            }
    }
}
