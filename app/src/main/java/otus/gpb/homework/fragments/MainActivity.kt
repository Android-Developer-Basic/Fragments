package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    lateinit var fragmentA: FragmentA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentA = FragmentA()

        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_frame, fragmentA)
                .commit()
            Log.d("app", "main_activity")
        }
    }

    /*override fun onBackPressed() {
        if (fragmentA.childFragmentManager.backStackEntryCount > 0) {
            fragmentA.childFragmentManager.popBackStack()
        }
        else {
            super.onBackPressed()
        }
    }*/
}