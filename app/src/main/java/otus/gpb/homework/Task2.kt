package otus.gpb.homework

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import otus.gpb.homework.fragments.FragmentBA
import otus.gpb.homework.fragments.FragmentBB
import otus.gpb.homework.fragments.R

class Task2 : AppCompatActivity() {
    var mainContainer: FragmentContainerView? = null
    var baContainer: FragmentContainerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_task2)

        val mainContainer: FragmentContainerView? = findViewById(R.id.fragment_container)
        val baContainer: FragmentContainerView? = findViewById(R.id.container_ba)

        if (mainContainer != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentBA())
                .addToBackStack(null)
                .commit()
        }

        if (baContainer != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_ba, FragmentBA())
                .replace(R.id.container_bb, FragmentBB())
                .commit()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            finish()
        }
    }


}