package otus.gpb.homework.fragments.task1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null ) {
            val fragment = FragmentButtonToActivity.InctanceFromActivity()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }


    companion object{
        fun newIntentMainActivity(context: Context) : Intent{
            return Intent(context, MainActivity::class.java)
        }
    }

}