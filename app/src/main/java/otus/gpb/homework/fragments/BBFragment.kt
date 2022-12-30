package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf

class BBFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(resources.getColor(R.color.teal_700, null))
        view.findViewById<Button>(R.id.sendColor).setOnClickListener {
            parentFragmentManager.setFragmentResult(
                COLOR_ID_BUNDLE_KEY,
                bundleOf(COLOR_ID_VALUE to ColorGenerator.generateColor())
            )
            parentFragmentManager.popBackStack()
        }
    }

    companion object {
        var COLOR_ID_BUNDLE_KEY = "colorId"
        var COLOR_ID_VALUE = "value"
    }
}