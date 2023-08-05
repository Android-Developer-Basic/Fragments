package otus.gpb.homework.fragments.task1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.fragment_a_open_button).apply {
            text = context.getString(R.string.open_frag_button, FragmentA.TAG)

            setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_a_container, FragmentA())
                    .addToBackStack(FragmentA.TAG)
                    .commit()
            }
        }
    }
}