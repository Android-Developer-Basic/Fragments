package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB: Fragment(R.layout.fragment_bb) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSendColor = view.findViewById<Button?>(R.id.send_color)
        buttonSendColor.setOnClickListener {
            val result = Bundle()
            result.putInt("color", ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult("value", result)
        }
    }
}