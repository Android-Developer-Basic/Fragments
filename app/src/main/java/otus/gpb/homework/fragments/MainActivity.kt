package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "OnCreate")
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null ) {
            val fragment = FragmentButtonToActivity.InctanceFromActivity()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }

}