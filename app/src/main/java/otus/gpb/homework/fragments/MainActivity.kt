package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

const val KEY_COLOR = "color"

class MainActivity : AppCompatActivity() {

    private lateinit var buttonFirst: Button
    private lateinit var buttonSecond: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFirst = findViewById(R.id.first_task)
        buttonSecond = findViewById(R.id.container_bb)

        buttonFirst.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        buttonSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}