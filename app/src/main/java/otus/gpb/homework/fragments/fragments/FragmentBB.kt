package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.ScreenOrientationHelper

class FragmentBB : Fragment(R.layout.fragment_b_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.sendColor).setOnClickListener {

            val bundle = Bundle()
            bundle.putInt("color", ColorGenerator.generateColor())

            parentFragmentManager.setFragmentResult("colorBundle", bundle)

            if (ScreenOrientationHelper.getScreenOrientation(resources) == "PORTRAIT") {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerBA, FragmentBA())
                    .commit()
            }
        }
    }
}