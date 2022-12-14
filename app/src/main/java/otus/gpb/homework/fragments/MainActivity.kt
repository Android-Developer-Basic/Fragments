package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.Open_Activity_A).setOnClickListener()
        {
            startActivity(Intent(this, MainActivity_A::class.java))
        }

        findViewById<Button>(R.id.Open_Activity_B).setOnClickListener()
        {
            startActivity(Intent(this, MainActivity_B::class.java))
        }
    }
}