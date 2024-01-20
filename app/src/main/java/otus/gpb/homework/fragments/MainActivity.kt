package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val tasksViewModel by viewModels<FragmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.start_task1_btn).setOnClickListener { startTask1Activity() }
        findViewById<Button>(R.id.start_task2_btn).setOnClickListener { startTask2Activity() }
    }

    private fun startTask1Activity() {
        val intent = Intent(this, Task1Activity::class.java)
        startActivity(intent)
    }

    private fun startTask2Activity() {
        val intent = Intent(this, Task2Activity::class.java)
        startActivity(intent)
    }
}