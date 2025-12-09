package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orientation = requireActivity().resources.configuration.orientation

        val btnSendColor = view.findViewById<Button>(R.id.btn_send_color)

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btnSendColor.setOnClickListener {
                val color = ColorGenerator.generateColor()
                sendResult(color = color)
            }
        } else {
            btnSendColor.setOnClickListener {
                val color = ColorGenerator.generateColor()
                sendResult(color = color)
                parentFragmentManager.popBackStack()
            }
        }
    }
}