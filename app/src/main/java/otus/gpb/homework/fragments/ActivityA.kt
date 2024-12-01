package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class ActivityA : AppCompatActivity() {
    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        findViewById<Button>(R.id.open_fragment_a).setOnClickListener() {
            if (savedInstanceState == null) {
                fragmentA = FragmentA()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_a_container, FragmentA(), "frA")
                    .addToBackStack(null)
                    .commit()
            } else {
                fragmentA = supportFragmentManager.findFragmentByTag("frA") as FragmentA
            }
        }
    }
}