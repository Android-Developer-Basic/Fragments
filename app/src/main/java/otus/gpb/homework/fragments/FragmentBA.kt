package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

private const val resultLKeyValue = "colorResult"
private const val value = "Color"

class FragmentBA : Fragment(R.layout.fragment_ba) {

    private lateinit var fragmentView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentView = view
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            view.findViewById<Button>(R.id.btn_open_fr_bb).setOnClickListener{
                parentFragmentManager.beginTransaction()
                    .add(R.id.task_two_container, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }

        parentFragmentManager.setFragmentResultListener(resultLKeyValue,this) {
            requestKey,result->
            if(requestKey == resultLKeyValue) {
                val color = result.getInt(value, Color.WHITE)
                fragmentView.setBackgroundColor(color)
            }
        }
    }
}