package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA: Fragment(R.layout.aa_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ColorGenerator.generateColor())

        view.findViewById<Button>(R.id.openFragmentAB).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentAB())
                .addToBackStack("")
                .commit()
        }
    }
}