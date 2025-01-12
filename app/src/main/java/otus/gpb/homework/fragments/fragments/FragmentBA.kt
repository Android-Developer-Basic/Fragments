package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.ScreenOrientationHelper

class FragmentBA : Fragment(R.layout.fragment_b_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("colorBundle", this) { _, bundle ->
            val color = bundle.getInt("color")
            this.view?.setBackgroundColor(color)
        }

        with(view.findViewById<Button>(R.id.openFragmentBB)) {

            setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerBA, FragmentBB())
                    .commit()
            }

            isVisible = ScreenOrientationHelper.getScreenOrientation(resources) == "PORTRAIT"
        }
    }
}