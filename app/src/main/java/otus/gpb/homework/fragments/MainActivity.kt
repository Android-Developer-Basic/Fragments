package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    private var visibleBtn = true
    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var fragment : Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // задание 1
        btn1 = findViewById<Button>(R.id.button_work1)
        btn1.setOnClickListener {
            btn_visible(false)

            fragment = FragmentA()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, fragment, "fragmentA")
                .addToBackStack("A_transaction")
                .commit()
        }

        //задание 2
        btn2 = findViewById(R.id.button_work2)
        btn2.setOnClickListener {
            btn_visible(false)

            fragment = FragmentB()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, fragment, "fragmentB")
                .addToBackStack("B_transaction")
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
        // при повороте обновляем видимость
        btn_visible(visibleBtn)
    }

    private fun btn_visible(state : Boolean) {
        visibleBtn=state
        if (state) {
            btn1.visibility = View.VISIBLE
            btn2.visibility = View.VISIBLE
        } else {
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // находясь на стартовой странице жмем back и закрываем приложение
        if (this.isFinishing) {
            finishAffinity()
            System.exit(0)
        }

        if (supportFragmentManager.backStackEntryCount == 0) {
                btn_visible(true)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("VisibleBtn", visibleBtn)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        visibleBtn = savedInstanceState.getBoolean("VisibleBtn")
    }
}