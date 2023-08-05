package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment(R.layout.fragment_b_b) {

    companion object {
        const val COLOR = "color"
        const val RESULT = "result"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button?>(R.id.send_color_button)?.setOnClickListener {
            val result = Bundle()
            result.putInt(COLOR, ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult(RESULT, result)
            parentFragmentManager.popBackStack()
        }
    }
}