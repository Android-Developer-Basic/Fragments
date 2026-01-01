package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonOpenAA = view.findViewById<Button>(R.id.btnOpenAA)

        buttonOpenAA.setOnClickListener {
            val fragmentAA = FragmentAA()

            val color = ColorGenerator.generateColor()

            val args = Bundle()
            args.putInt("color_key", color)
            fragmentAA.arguments = args

            childFragmentManager.beginTransaction()
                .replace(R.id.child_container, fragmentAA)
                .addToBackStack(null)
                .commit()
        }
    }
}