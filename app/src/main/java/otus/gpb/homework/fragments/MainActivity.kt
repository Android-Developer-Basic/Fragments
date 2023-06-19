package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import otus.gpb.homework.fragments.usecaseA.ActivityA
import otus.gpb.homework.fragments.usecaseB.ActivityB

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<AppCompatButton>(R.id.button_open_activity_a)?.setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        findViewById<AppCompatButton>(R.id.button_open_activity_b)?.setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}