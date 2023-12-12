package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_b)
        findViewById<View>(R.id.fragmentContainerB)?.apply {
            supportFragmentManager
                .beginTransaction()
                .replace(id, FragmentBa(), FragmentBa::class.java.simpleName)
                .commit()
        }
        findViewById<View>(R.id.fragmentContainerBa)?.apply {
            supportFragmentManager
                .beginTransaction()
                .replace(id, FragmentBa(), FragmentBa::class.java.simpleName)
                .commit()
        }
        findViewById<View>(R.id.fragmentContainerBb)?.apply {
            supportFragmentManager
                .beginTransaction()
                .replace(id, FragmentBb(), FragmentBb::class.java.simpleName)
                .commit()
        }
    }
}