package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.Objects

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        if (isLandscapeOrientation()) {
            findViewById<FrameLayout>(R.id.second_frame_bb_layout).visibility = View.VISIBLE

            supportFragmentManager.beginTransaction()
                .replace(R.id.second_frame_ba_layout, FragmentBA())
                .replace(R.id.second_frame_bb_layout, FragmentBB())
                .commit()
        } else {
            findViewById<FrameLayout>(R.id.second_frame_bb_layout).visibility = View.GONE

            supportFragmentManager.beginTransaction()
                .replace(R.id.second_frame_ba_layout, FragmentBA())
                .commit()
        }
    }

    private fun isLandscapeOrientation() =
        Objects.equals(Configuration.ORIENTATION_LANDSCAPE, resources.configuration.orientation)
}
