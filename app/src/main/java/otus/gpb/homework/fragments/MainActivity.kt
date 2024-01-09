package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val buttonOpenFragmentA = findViewById<Button>(R.id.buttonOpenFragmentA)
        val buttonOpenTask2 = findViewById<Button>(R.id.buttonOpenTask2)
        buttonOpenFragmentA.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, FragmentA())
                .commit()
            buttonOpenFragmentA.visibility = View.GONE
            buttonOpenTask2.visibility = View.GONE
        }

        buttonOpenTask2.setOnClickListener {
            val intent = Intent(this, ActivityTask2::class.java)
            startActivity(intent)
        }
    }
}