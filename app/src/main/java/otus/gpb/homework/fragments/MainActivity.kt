package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //determinePaneLayout()

        findViewById<Button>(R.id.b_open_task_a).setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.task_one_container,FragmentA(),"Fragment A").commit()
        }

        findViewById<Button>(R.id.b_open_task_b).setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.task_two_container,FragmentBA(),"Fragment BA").commit()
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.task_two_container_second,FragmentBB(),"Fragment BB").commit()
            }
        }
    }

    /*private fun determinePaneLayout() { // Пытался при смене оринтации преместить фрагмент в другой контейнер не получилось что-то не так делал. ПОдскажите как такое можно сделать и надо ли
        val fragmentItemDetail : FrameLayout? = findViewById(R.id.task_two_container_second)
        if (fragmentItemDetail != null) {
            val fragmentB : Fragment? = supportFragmentManager.findFragmentByTag("Fragment BB")
            if(fragmentB != null) {
                fragmentB.onDetach()
                supportFragmentManager.beginTransaction().replace(
                    R.id.task_two_container_second,FragmentBB(),"Fragment BB").commit()
            }
        }
    }*/
}