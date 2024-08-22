package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var buttonFragmentA: Button
    private lateinit var buttonFragmentB: Button
    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFragmentA = findViewById(R.id.button_fragment_a)
        buttonFragmentB = findViewById(R.id.button_fragment_b)

        buttonFragmentA.setOnClickListener {
            fragmentA = FragmentA()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragmentA)
                .commit()
            buttonFragmentA.visibility = View.GONE
            buttonFragmentB.visibility = View.GONE
        }

        buttonFragmentB.setOnClickListener {
            startActivity(Intent(this, FragmentBActivity::class.java))
        }

        supportFragmentManager.addOnBackStackChangedListener {
            val count = supportFragmentManager.backStackEntryCount
            if (count == 0) {
                buttonFragmentA.visibility = View.VISIBLE
                buttonFragmentB.visibility = View.VISIBLE
            }
        }
    }
}