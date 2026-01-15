package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

private const val COLOR_ARG = "color_arg"
private const val FRAGMENT_REQUESTED_COLOR = "fr_req_color"

class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.send_color_btn).setOnClickListener {
            val result = Bundle().apply { putInt(COLOR_ARG, ColorGenerator.generateColor()) }
            parentFragmentManager.setFragmentResult(FRAGMENT_REQUESTED_COLOR, result)

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.popBackStack()
            }
        }

    }
}