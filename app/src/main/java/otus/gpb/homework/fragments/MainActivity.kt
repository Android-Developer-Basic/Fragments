package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.fragments.FragmentA
import kotlin.concurrent.fixedRateTimer
const val COLOR_PARAM = "COLOR_PARAM"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            val fragmentA = FragmentA.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentA)
                .commit()
        }

    }
}