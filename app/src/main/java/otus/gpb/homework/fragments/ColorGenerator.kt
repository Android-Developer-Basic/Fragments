package otus.gpb.homework.fragments

import android.graphics.Color
import java.util.Random

object ColorGenerator {

    const val ARG_COLOR = "arg_color"
    const val ARG_COLOR_REQUEST = "arg_color_request"

    fun generateColor(): Int {
        val nextInt = Random().nextInt(0xffffff + 1)
        val colorCode = String.format("#%06x", nextInt)
        return Color.parseColor(colorCode)
    }
}