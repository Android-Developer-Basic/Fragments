package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_b)

        if (savedInstanceState == null) {
            val currentOrientation = resources.configuration.orientation
            val fragmentBA = FragmentBA.newInstance(Color.WHITE)

            if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_b_activity_container, fragmentBA)
                    .commit()
            } else {
                val fragmentBB = FragmentBB.newInstance(Color.YELLOW)

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_ba_land, fragmentBA)
                    .replace(R.id.fragment_container_bb_land, fragmentBB)
                    .commit()
            }
        }
    }

    companion object {
        const val REQUEST_KEY_COLOR = "request_key_color"
        const val BUNDLE_KEY_COLOR = "bundle_key_color"
    }
}
