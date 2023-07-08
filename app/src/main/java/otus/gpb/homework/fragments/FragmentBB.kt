package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

private const val resultLKeyValue = "colorResult"
private const val value = "Color"

class FragmentBB : Fragment(R.layout.fragment_bb) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_send_color).setOnClickListener {
            val color = ColorGenerator.generateColor()
            val result = Bundle()
            result.putInt(value,color)
            parentFragmentManager.setFragmentResult(resultLKeyValue, result)
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}