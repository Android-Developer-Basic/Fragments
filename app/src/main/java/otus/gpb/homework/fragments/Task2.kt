package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class Task2 : AppCompatActivity(R.layout.activity_2_task) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
}