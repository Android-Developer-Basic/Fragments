package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity(), OnBackPressedDispatcherOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val homeworkPartOneButton = findViewById<Button>(R.id.homeworkPartOneButton)
        val homeworkPartTwoButton = findViewById<Button>(R.id.homeworkPartTwoButton)

        homeworkPartOneButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        homeworkPartTwoButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
