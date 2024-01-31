package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var buttonOpenFragmentA: Button
    private lateinit var buttonOpenTask2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buttonOpenFragmentA = findViewById(R.id.buttonOpenFragmentA)
        buttonOpenTask2 = findViewById(R.id.buttonOpenTask2)
    }

    override fun onStart() {
        super.onStart()
        buttonOpenFragmentA.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, FragmentA())
                .commit()
            buttonOpenFragmentA.visibility = View.GONE
            buttonOpenTask2.visibility = View.GONE
        }

        buttonOpenTask2.setOnClickListener {
            val intent = Intent(this, Task2::class.java)
            startActivity(intent)
        }
    }
}
