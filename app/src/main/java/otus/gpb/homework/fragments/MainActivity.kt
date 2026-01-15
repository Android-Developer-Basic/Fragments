package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.activity_a_btn).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        findViewById<MaterialButton>(R.id.activity_b_btn).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}
