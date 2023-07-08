package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

private const val value = "Color"

class FragmentAA : Fragment(R.layout.fragment_aa) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            view.setBackgroundColor(it.getInt(value))
        }

        view.findViewById<Button>(R.id.btn_open_fr_ab).setOnClickListener {
            val color = ColorGenerator.generateColor()

            parentFragment?.childFragmentManager
                ?.beginTransaction()
                ?.addToBackStack(null)
                ?.add(R.id.child_content_container, FragmentAB.newInstance(color))
                ?.commit()
        }
    }

    companion object {
        fun newInstance(color: Int) = FragmentAA().apply {
            arguments = Bundle().apply {
                putInt(value, color)
            }
        }
    }

}