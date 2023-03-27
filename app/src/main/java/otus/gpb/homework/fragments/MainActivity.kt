package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.open_fragment_btn).setOnClickListener {
            fragmentA = FragmentA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, fragmentA)
                .addToBackStack(null)
                .commit()
        }

        findViewById<Button>(R.id.open_second_activity_btn).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {

            }

            startActivity(intent)
        }
    }
}