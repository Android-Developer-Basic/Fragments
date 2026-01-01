package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = arguments?.getInt("color_key") ?: 0
        view.setBackgroundColor(color)

        val buttonOpenAB = view.findViewById<Button>(R.id.btnOpenAB)
        buttonOpenAB.setOnClickListener {
            val fragmentAB = FragmentAB()
            val bundle = Bundle()
            bundle.putInt("color_key", ColorGenerator.generateColor())
            fragmentAB.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.child_container, fragmentAB)
                .addToBackStack(null)
                .commit()
        }
    }
}