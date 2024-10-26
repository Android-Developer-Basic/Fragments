package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_aa, container, false)

        arguments?.getInt("color")?.let { view.setBackgroundColor(it) }

        view.findViewById<Button>(R.id.openFragmentAbButton).setOnClickListener {
            val fragmentAb = FragmentAB()
            val args = Bundle()
            args.putInt("color", ColorGenerator.generateColor())
            fragmentAb.arguments = args

            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout_fragment_a, fragmentAb)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
