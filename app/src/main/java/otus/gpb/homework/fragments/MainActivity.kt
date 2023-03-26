package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.taskA.ActivityA
import otus.gpb.homework.fragments.taskB.ActivityB

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.open_task_a).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java ))
        }

        findViewById<Button>(R.id.open_task_b).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java ))
        }
    }
}