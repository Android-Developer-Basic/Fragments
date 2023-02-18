package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.first.FirstTaskActivity
import otus.gpb.homework.fragments.second.SecondTaskActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.b_open_task_a).setOnClickListener {
            val intent = Intent(this, FirstTaskActivity::class.java)
            startActivity(intent)

        }

        findViewById<Button>(R.id.b_open_task_b).setOnClickListener {
            val intent = Intent(this, SecondTaskActivity::class.java)
            startActivity(intent)

        }
    }
}








