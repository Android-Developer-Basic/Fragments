package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSecondActivity = findViewById<Button>(R.id.secondTask)
        val buttonFragmentA = findViewById<Button>(R.id.buttonFragmentA)

        buttonFragmentA.setOnClickListener {
            showFragmentA()
        }
        buttonSecondActivity.setOnClickListener {
            val intent = Intent(this, ActivitySecond::class.java)
            startActivity(intent)
        }
    }

    private fun showFragmentA() {
        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentA)
            .addToBackStack("fragmentA")
            .commit()
    }
}
