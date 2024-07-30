package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment


class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = arguments?.getInt("color")
        if (color != null) {
            view.setBackgroundColor(color)
        }

        val buttonFragmentAB = view.findViewById<Button>(R.id.buttonFragmentAB)
        val fragmentAB = FragmentAB()
        val bundle = Bundle()
        buttonFragmentAB.setOnClickListener {
            bundle.putInt("color", ColorGenerator.generateColor())
            fragmentAB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_fragmentAA, fragmentAB)
                .addToBackStack(null)
                .commit()
        }

    }
}