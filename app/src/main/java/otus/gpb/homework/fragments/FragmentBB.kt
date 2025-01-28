package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bb, container, false)

        val fragmentBA = FragmentBA()
        view.findViewById<Button>(R.id.buttonSendColor)
            .setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout_ba, fragmentBA).apply {
                        val args = Bundle()
                        args.putInt("key_color", ColorGenerator.generateColor())
                        fragmentBA.arguments = args
                        parentFragmentManager.setFragmentResult("key_color", args)
                    }
                    .commit()
            }

        return view
    }
}