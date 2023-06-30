package otus.gpb.homework.fragments.usecaseB

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentBB : Fragment(R.layout.fragment_bb) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("app", "fragment_bb on view")

        view.findViewById<AppCompatButton>(R.id.button_send_color).setOnClickListener {
            val color = ColorGenerator.generateColor()

            Log.d("app", "Sent color to FragmentBA#$color")

            setFragmentResult("key", bundleOf("color" to color))

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity?.onBackPressed()
            }
        }
    }

}