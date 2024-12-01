package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class Exercise_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_2)

        /*
        findViewById<FragmentContainerView>(R.id.fragment_BA)?.setBackgroundColor(ColorGenerator.generateColor())
        findViewById<FragmentContainerView>(R.id.fragment_BB)?.setBackgroundColor(ColorGenerator.generateColor())

         */

        if (findViewById<FrameLayout>(R.id.fragment_container) != null) {
            val key = "FragmentBA"
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, FragmentBA(), key)
                .commit()
        }
    }
}
