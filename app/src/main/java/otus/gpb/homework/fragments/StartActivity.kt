package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.task1.MainActivity
import otus.gpb.homework.fragments.task2.ActivityTask2

class StartActivity : AppCompatActivity() {

    private val task1 by lazy {
        findViewById<Button>(R.id.task1)
    }

    private val task2 by lazy {
        findViewById<Button>(R.id.task2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        task1.setOnClickListener {
            startActivity(MainActivity.newIntentMainActivity(this))
        }
        task2.setOnClickListener {
            startActivity(ActivityTask2.newIntentActivityTask2(this))
        }
    }
}