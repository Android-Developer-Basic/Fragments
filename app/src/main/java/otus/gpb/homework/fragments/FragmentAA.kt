package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class FragmentAA : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt("color")?.let { color ->
            view.setBackgroundColor(color)
        }



        view.findViewById<Button>(R.id.open_fragment_ab_button).setOnClickListener {
            val color = ColorGenerator.generateColor()

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_a_container, FragmentAB().apply {
                    arguments = Bundle().apply {
                        putInt("color", color)
                    }
                })
                addToBackStack(null)
                commit()
            }
        }
    }
}