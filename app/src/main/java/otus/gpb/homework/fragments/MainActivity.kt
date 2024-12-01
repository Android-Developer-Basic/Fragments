package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnBackPressedDispatcherOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAButton = findViewById<Button>(R.id.openFragmentAButton)

        fragmentAButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.frame_layout, FragmentA())
                addToBackStack(null)
                commit()
            }
        }
    }
}
