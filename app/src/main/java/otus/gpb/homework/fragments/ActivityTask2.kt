package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityTask2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_2)

        val fragmentBA = FragmentBA()
        val fragmentBB = FragmentBB()

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container_ba, fragmentBA).commit()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container_bb, fragmentBB).commit()
            }
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction().add(R.id.portrait_container, fragmentBA).commit()
//            button.setOnClickListener() {
//                supportFragmentManager.beginTransaction().replace(R.id.portrait_container, fragmentBB).commit()
//            }
        }
        }

    }
