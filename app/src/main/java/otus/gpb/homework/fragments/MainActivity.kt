package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

const val KEY_COLOR = "color"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonTask1 = findViewById<Button>(R.id.task1)
        val buttonTask2 = findViewById<Button>(R.id.task2)
        buttonTask1.setOnClickListener {
            it.visibility = GONE
            buttonTask2.visibility = GONE
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, FragmentA())
                .addToBackStack(null)
                .commit()
        }
        buttonTask2.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}