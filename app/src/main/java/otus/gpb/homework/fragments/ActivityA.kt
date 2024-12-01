package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        findViewById<Button>(R.id.open_fragment_a_button).setOnClickListener()
        {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    FragmentA.newInstance(
                        ColorGenerator.generateColor(),
                        getString(R.string.open_fragment_aa)
                    )
                )
                .addToBackStack(null)
                .commit()
        }
    }
}