package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            // some code

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().supportFragmentManager.setFragmentResultListener("request_key", this) { _, bundle ->
            val result = bundle.getInt("color")
            view.setBackgroundColor(result)
        }

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            val button = view.findViewById<Button>(R.id.buttonOpenFragmentBB)
            button.setOnClickListener() {
                parentFragmentManager.beginTransaction().replace(R.id.portrait_container, FragmentBB()).addToBackStack(null).commit()
            }
        }
    }
}