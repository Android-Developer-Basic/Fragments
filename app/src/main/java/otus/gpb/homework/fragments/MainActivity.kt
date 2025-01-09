package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


const val KEY_COLOR = "color"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFirst = findViewById<Button>(R.id.container_a)
        val buttonSecond = findViewById<Button>(R.id.container_b)

        buttonFirst.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        buttonSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}