package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.screens.FragmentA

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, FragmentA())
            .commit()
    }
}