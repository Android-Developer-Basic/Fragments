package otus.gpb.homework.fragments.usecaseB

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentBB : Fragment(R.layout.fragment_bb) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(this@FragmentBB.context, "FragmentBB", Toast.LENGTH_SHORT).show()

        view.findViewById<AppCompatButton>(R.id.button_send_color).setOnClickListener {
            val color = ColorGenerator.generateColor()

            Log.d("app", "Sent color to FragmentBA#$color")

            setFragmentResult("key", bundleOf("color" to color))
            activity?.onBackPressed()
        }
    }
}