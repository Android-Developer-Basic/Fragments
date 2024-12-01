package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class SecondTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_task_activity)

        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT ->
                supportFragmentManager.commit {
                    replace<FragmentBA>(R.id.first_fragment_container)
                    addToBackStack(null)
                }
            Configuration.ORIENTATION_LANDSCAPE ->
                supportFragmentManager.commit {
                    replace<FragmentBB>(R.id.second_fragment_container)
                    addToBackStack(null)
                }
        }
    }
}