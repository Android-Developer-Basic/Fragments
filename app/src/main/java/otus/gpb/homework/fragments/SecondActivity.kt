package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import otus.gpb.homework.fragments.fragments.FragmentBA
import otus.gpb.homework.fragments.fragments.FragmentBB

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        if (savedInstanceState == null) {
            val fragment = FragmentBA.newInstance(ColorGenerator.generateColor())
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
            if(findViewById<FragmentContainerView>(R.id.fragmentContainerBB) != null){
                val fragmentBB = FragmentBB.newInstance()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerBB, fragmentBB)
                    .commit()
            }
        }
    }
}