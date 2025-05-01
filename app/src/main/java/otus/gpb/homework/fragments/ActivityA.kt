package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        if (savedInstanceState == null) {
            fragmentA = FragmentA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_a_container, fragmentA)
                .commit()
        }
    }
}