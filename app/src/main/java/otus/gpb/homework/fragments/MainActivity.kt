package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.open_task_1).setOnClickListener {
            startActivity(Intent(this, FirstTaskActivity::class.java))
        }

        findViewById<Button>(R.id.open_task_2).setOnClickListener {
            startActivity(Intent(this, SecondTaskActivity::class.java))
        }
    }
}