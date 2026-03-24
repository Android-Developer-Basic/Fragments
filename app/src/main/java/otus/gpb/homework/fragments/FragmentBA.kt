package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

private const val COLOR_ARG = "color_arg"
private const val FRAGMENT_REQUESTED_COLOR = "fr_req_color"

class FragmentBA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(FRAGMENT_REQUESTED_COLOR, this) { _, bundle ->
            val backgroundColor = bundle.getInt(COLOR_ARG, Color.WHITE)
            view.setBackgroundColor(backgroundColor)
        }

        val openBbBtn = view.findViewById<MaterialButton>(R.id.fragment_bb_btn)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            openBbBtn.visibility = View.GONE
        } else {
            openBbBtn.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_b, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}