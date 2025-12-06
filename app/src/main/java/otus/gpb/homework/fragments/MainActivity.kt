package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.btn_open_activity1)
        val button2 = findViewById<Button>(R.id.btn_open_activity2)

        button1.setOnClickListener {
            val intent = Intent(this, Activity1::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
    }
}