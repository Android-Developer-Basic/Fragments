package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFragmentA = findViewById<Button>(R.id.showFragmentA)

        buttonFragmentA.setOnClickListener{

            if(savedInstanceState==null) {
                fragmentA = FragmentA()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.containerA, fragmentA,"fragment")
                    .commit()

            }
        }

        findViewById<Button>(R.id.show_task2).setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

    }



}
