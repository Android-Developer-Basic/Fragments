package otus.gpb.homework.fragments.taskB

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import otus.gpb.homework.fragments.R

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_ba_land, FragmentBA())
                .replace(R.id.container_bb_land, FragmentBB())
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_b_portrait, FragmentBA())
                .addToBackStack(null)
                .commit()
        }
    }
}