package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class ActivityTask2: AppCompatActivity(R.layout.activity_second_task) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainContainer: FragmentContainerView? = findViewById(R.id.main_container)
        if (mainContainer != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, FragmentBA())
                .addToBackStack(null)
                .commit()
        }
        val baContainer: FragmentContainerView? = findViewById(R.id.container_ba)
        if (baContainer != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_ba, FragmentBA())
                .replace(R.id.container_bb, FragmentBB())
                .commit()
        }
    }
}