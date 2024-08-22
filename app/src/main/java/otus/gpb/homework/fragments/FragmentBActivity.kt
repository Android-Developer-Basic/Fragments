package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.ui.FragmentBA
import otus.gpb.homework.fragments.ui.FragmentBB

class FragmentBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_b)

        val fragmentBA = FragmentBA()
        val fragmentBB = FragmentBB()

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            supportFragmentManager.beginTransaction().add(R.id.fragment_container_ba, fragmentBA)
//                .commit()
//            supportFragmentManager.beginTransaction().add(R.id.fragment_container_bb, fragmentBB)
//                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_ba, fragmentBA)
                .replace(R.id.fragment_container_bb, fragmentBB)
                .commit()
        }
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction().add(R.id.activity_fragment_b, fragmentBA)
                .commit()
        }
    }

    companion object {
        const val KEY_COLOR = "color"
        const val KEY_REQUEST = "request_key"
    }
}