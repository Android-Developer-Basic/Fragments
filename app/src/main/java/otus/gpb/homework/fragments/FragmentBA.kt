package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnOpenBB = view.findViewById<Button>(R.id.btnOpenBB)

        btnOpenBB?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_b, FragmentBB())
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener("color_request", viewLifecycleOwner) { _, bundle ->
            val color = bundle.getInt("color_result")
            view.setBackgroundColor(color)
        }

        if (activity?.findViewById<View>(R.id.container_bb) != null) {
            btnOpenBB?.visibility = View.GONE
        }
    }
}