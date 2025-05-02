package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {
    private val saveColor = "saveColor"
    private var baColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        if (savedInstanceState != null) {
            baColor = savedInstanceState.getInt(saveColor)
        }

        val fba = FragmentBA()

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_ba_container, fba)
                .replace(R.id.activity_bb_container, FragmentBB())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_b_container, fba)
                .commit()
        }

        fba.sendColor(baColor)
        supportFragmentManager.observeColor(this) {color ->
            baColor = color
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(saveColor, baColor)
    }
}