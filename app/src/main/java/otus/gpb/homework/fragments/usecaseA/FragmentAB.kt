package otus.gpb.homework.fragments.usecaseA

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R

class FragmentAB
constructor(
    color: Int = Color.WHITE
) : Fragment(R.layout.fragment_ab) {
    private val backgroundColor = color

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FrameLayout>(R.id.fragment_frame_ab)?.setBackgroundColor(backgroundColor)

        Log.d("app", "opened fragment_ab")
    }
}