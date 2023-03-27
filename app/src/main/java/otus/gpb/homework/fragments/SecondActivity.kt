package otus.gpb.homework.fragments

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    private lateinit var fragmentBA: FragmentBA
    private lateinit var fragmentBB: FragmentBB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if(savedInstanceState == null)
        {
            fragmentBA = FragmentBA()
            fragmentBB = FragmentBB()

            if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_first_container, fragmentBA, "ba")
                    .addToBackStack(null)
                    .commit()
            }
            else
            {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_first_container, fragmentBA, "ba")
                    .addToBackStack(null)
                    .replace(R.id.fragment_second_container, fragmentBB, "bb")
                    .addToBackStack(null)
                    .commit()
            }
        }
        else
        {
            fragmentBA = supportFragmentManager.findFragmentByTag("ba") as FragmentBA
            fragmentBB = supportFragmentManager.findFragmentByTag("bb") as FragmentBB
        }
    }
}