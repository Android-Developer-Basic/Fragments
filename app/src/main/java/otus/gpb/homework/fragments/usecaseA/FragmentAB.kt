package otus.gpb.homework.fragments.usecaseA

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R

class FragmentAB() : Fragment(R.layout.fragment_ab) {
    companion object {
        private const val COLOR = "color"

        fun create(value: Int): FragmentAB {
            val fragment = FragmentAB()
            val arguments = Bundle()
            arguments.putInt(COLOR, value)
            fragment.arguments = arguments
            return fragment
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(this@FragmentAB.context, "FragmentAB", Toast.LENGTH_SHORT).show()

        arguments?.getInt(COLOR)?.let {
            view.findViewById<FrameLayout>(R.id.fragment_frame_ab)?.setBackgroundColor(it)
        }

        Log.d("app", "opened fragment_ab")
    }
}