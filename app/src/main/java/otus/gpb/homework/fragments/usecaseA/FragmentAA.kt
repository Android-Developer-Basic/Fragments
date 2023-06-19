package otus.gpb.homework.fragments.usecaseA

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentAA
    constructor(
    color: Int = Color.WHITE
) : Fragment(R.layout.fragment_aa) {
    private val backgroundColor = color

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FrameLayout>(R.id.fragment_frame_aa)?.setBackgroundColor(backgroundColor)
        view.findViewById<AppCompatButton>(R.id.button_open_fragment_ab)?.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_frame_aa, FragmentAB(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
            Log.d("app", "clicked button to open fragment_ab")
        }
    }
}