package otus.gpb.homework.fragments.taskA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import otus.gpb.homework.fragments.R

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        findViewById<Button>(R.id.open_fragment_a).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_a, FragmentA())
                .addToBackStack(null)
                .commit()
        }
    }
}