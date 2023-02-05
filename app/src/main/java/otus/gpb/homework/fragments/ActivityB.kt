package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class ActivityB: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        supportFragmentManager.commit {
            replace<FragmentBA>(R.id.first_container)
            addToBackStack(null)
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.commit {
                replace<FragmentBB>(R.id.second_container)
                addToBackStack(null)
            }
        }
    }
}
