package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_openA).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_field,FragmentA())
                .addToBackStack("")
                .commit()
        }
    }
}