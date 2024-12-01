package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentResultListener

class FragmentBA : Fragment(R.layout.fragment_b_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.fragmentba_button)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentab_container, FragmentBB.newInstance())
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener("color", this, object : FragmentResultListener {
            override fun onFragmentResult(requestKey: String, result: Bundle) {
                if (requestKey == "color") {
                    val color = result.getInt("color")
                    view.setBackgroundColor(color)
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentBA()
    }
}