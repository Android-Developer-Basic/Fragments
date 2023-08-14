package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment(R.layout.fragment_bb) {
    companion object {
        const val ARG_COLOR = "color"
        const val VALUE = "value"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button?>(R.id.send_color)?.setOnClickListener {
            val result = Bundle()
            result.putInt(ARG_COLOR, ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult(VALUE, result)
            parentFragmentManager.popBackStack()
        }

    }
}
