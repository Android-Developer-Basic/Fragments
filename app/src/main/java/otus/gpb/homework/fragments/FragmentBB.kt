package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentBB : Fragment(R.layout.fragment_b_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSendColor = view.findViewById<Button>(R.id.send_color)
        buttonSendColor?.setOnClickListener {
            val result = Bundle()
            result.putInt("color", ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult("value", result)
        }
    }
}