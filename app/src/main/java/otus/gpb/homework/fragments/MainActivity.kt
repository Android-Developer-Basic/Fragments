package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_openA).setOnClickListener {
           supportFragmentManager
                .beginTransaction()
                .add(R.id.main_field,FragmentA())
                .addToBackStack("")
                .commit()
        }

        findViewById<Button>(R.id.btn_openB).setOnClickListener {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameforBA,FragmentBA())
                .addToBackStack("")
                .commit()

            if(this.resources.configuration.orientation.toString() == "2") {
                supportFragmentManager
                    .beginTransaction()
                    .remove(FragmentA())
                    .replace(R.id.frameforBB,FragmentBB())
                    .addToBackStack("")
                    .commit()
            }

        }
    }
}