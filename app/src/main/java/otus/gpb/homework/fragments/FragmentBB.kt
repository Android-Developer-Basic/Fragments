package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bb, container, false)

        val fragmentBa = FragmentBA()
        view.findViewById<Button>(R.id.sendColorButton)
            .setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.second_frame_ba_layout, fragmentBa).apply {
                        val args = Bundle()
                        args.putInt("color", ColorGenerator.generateColor())
                        fragmentBa.arguments = args

                        parentFragmentManager.setFragmentResult("color", args)
                    }
                    .commit()
            }

        return view
    }
}
