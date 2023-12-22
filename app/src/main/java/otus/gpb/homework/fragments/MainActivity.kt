package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var taskFragment: TasksFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskFragment = TasksFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, taskFragment)
            .commit()
    }
}