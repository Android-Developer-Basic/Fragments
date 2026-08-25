package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<android.view.View>(R.id.open_task_a_button).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }
        findViewById<android.view.View>(R.id.open_task_b_button).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}