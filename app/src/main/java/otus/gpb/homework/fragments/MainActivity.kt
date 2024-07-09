package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonToFragmentA)
        val fragmentA = FragmentA()

        button.setOnClickListener() {
            if (savedInstanceState == null && !fragmentA.isAdded) {
                supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragmentA).addToBackStack("fragmentA").commit()
            }
        }

    }

//    override fun onBackPressed() {
//        val count = supportFragmentManager.backStackEntryCount
//
//        if (count == 0) {
//            super.onBackPressed()
//        } else {
//          supportFragmentManager.popBackStack()
//        }
//}
}