package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.OpenFragment_A).setOnClickListener()
        {
            if(savedInstanceState == null)
            {
                val Fr_A = Fragment_A()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.FrameLayout, Fr_A, "Fr_A")
                    .addToBackStack(null)
                    .commit()
            }
        }

    }
}