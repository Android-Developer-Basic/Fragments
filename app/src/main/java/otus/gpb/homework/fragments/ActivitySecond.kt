package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivitySecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val fragmentBA = FragmentBA()
        val fragmentBB = FragmentBB()

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba, fragmentBA)
                .commit()
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba, fragmentBA)
                .commit()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_bb, fragmentBB)
                .commit()
        }
    }
}
