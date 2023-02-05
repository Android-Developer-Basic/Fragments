package otus.gpb.homework.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

private const val KEY = "COLOR"

class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            view.findViewById<ConstraintLayout>(R.id.fragment_aa)
                .setBackgroundColor(it.getInt(KEY))
        }

        view.findViewById<Button>(R.id.open_fragment_ab).setOnClickListener {
            val color = ColorGenerator.generateColor()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_aa_container, FragmentAB.newInstance(color))
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