package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.buttonOpenFragmentA).setOnClickListener {
            openFragmentA()
        }
    }

    private fun openFragmentA() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentA())
            .addToBackStack(null)
            .commit()
    }
}