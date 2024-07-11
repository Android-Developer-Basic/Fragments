package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOpenFragmentA = findViewById<Button>(R.id.buttonToFragmentA)
        val buttonOpenTask2 = findViewById<Button>(R.id.buttonOpenTask2)
        val fragmentA = FragmentA()

        buttonOpenFragmentA.setOnClickListener() {
            if (savedInstanceState == null && !fragmentA.isAdded) {
                supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragmentA).addToBackStack("fragmentA").commit()
            }
        }

        buttonOpenTask2.setOnClickListener() {
            val intent = Intent(this, ActivityTask2::class.java)
            startActivity(intent)
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