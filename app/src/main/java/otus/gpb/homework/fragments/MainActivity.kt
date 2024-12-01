package otus.gpb.homework.fragments

import android.content.Context
import android.content.Intent
import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.open_activity_a).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        findViewById<Button>(R.id.open_activity_b).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}