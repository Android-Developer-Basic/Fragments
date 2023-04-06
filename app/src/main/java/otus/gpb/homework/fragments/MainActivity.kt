package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_open_frgA).apply {
            setOnClickListener {
                val key = "FragmentA"
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_A, FragmentA(), key)
                    .addToBackStack(key)
                    .commit()
            }
        }

        findViewById<Button>(R.id.button_exercise_2).apply {
            setOnClickListener {
                startActivity(Intent(this@MainActivity, Exercise_2::class.java))
            }
        }

    }
}
