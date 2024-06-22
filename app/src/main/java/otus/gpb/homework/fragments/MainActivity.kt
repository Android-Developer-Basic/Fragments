package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickFun(view: View) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.replace(R.id.A_container, FragmentA())
        transaction.addToBackStack(null)
        transaction.commit()

        findViewById<View>(R.id.textView).visibility = View.GONE
        findViewById<View>(R.id.ToFragmentAbtn).visibility = View.GONE


//        fragmentA = FragmentA()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.A_container, fragmentA)
//            .addToBackStack(null) // Добавляем транзакцию в стек возврата
//            .commit()
    }


}
