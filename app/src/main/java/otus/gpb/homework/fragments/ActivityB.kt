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
        findViewById<View>(R.id.fragmentContainerB)
            ?.apply {
                supportFragmentManager
                    .beginTransaction()
                    .replace(id, FragmentBa(), FragmentBa::class.java.simpleName)
                    .commit()
            }
            ?: supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerBa, FragmentBa(), FragmentBa::class.java.simpleName)
                .replace(R.id.fragmentContainerBb, FragmentBb(), FragmentBb::class.java.simpleName)
                .commit()
    }
}