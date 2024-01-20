package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class Task2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        if (findViewById<View>(R.id.fragment_bb_container) != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba_container, FragmentBA())
                .replace(R.id.fragment_bb_container, FragmentBB())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba_container, FragmentBA())
                .commit()
        }
    }
}