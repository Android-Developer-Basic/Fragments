package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.content.res.Resources

object ScreenOrientationHelper {

    fun getScreenOrientation(resources: Resources): String {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> "PORTRAIT"
            Configuration.ORIENTATION_LANDSCAPE -> "LANDSCAPE"
            else -> ""
        }
    }
}