package otus.gpb.homework.fragments.second

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import otus.gpb.homework.fragments.R

class SecondTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)

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
