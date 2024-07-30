package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().supportFragmentManager.setFragmentResultListener(
            "requestKey",
            this
        ) { _, bundle ->
            val result = bundle.getInt("color")
            view.setBackgroundColor(result)
        }
        val buttonFragmentBB = view.findViewById<Button>(R.id.buttonFragmentBB)
        buttonFragmentBB.setOnClickListener {
            val fragmentBB = FragmentBB()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_bb, fragmentBB)
                .addToBackStack(null)
                .commit()
        }
    }
}
