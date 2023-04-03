package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         findViewById<Button>(R.id.open_a_button).setOnClickListener {

             supportFragmentManager.beginTransaction()
                 .replace(R.id.fragment_container, FragmentA())
                 .commit()
         }

        findViewById<Button>(R.id.open_task_2).setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }


    }
}