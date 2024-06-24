package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var BAFragment: FragmentBA
    private lateinit var BBFragment: FragmentBB

    private var isTablet = false // false - портрет, true - лендскейп

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if (savedInstanceState == null) {
            BAFragment = FragmentBA()
            BBFragment = FragmentBB()

        }

        val fragmentDetailContainer = findViewById<ViewGroup>(R.id.BAcontainer)
        if (fragmentDetailContainer != null) {
            isTablet = true
        }

        if (isTablet){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            transaction.replace(R.id.BAcontainer, FragmentBA())
            transaction.replace(R.id.BB_container, FragmentBB())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        else {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            transaction.replace(R.id.FragmentContainer, FragmentBA())
            transaction.addToBackStack(null)
            transaction.commit()


        }

    }

    fun openFragmentBaOnClick(view: View){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.replace(R.id.FragmentContainer, FragmentBB())
        transaction.addToBackStack(null)
        transaction.commit()
        findViewById<View>(R.id.textView).visibility = View.GONE
        findViewById<View>(R.id.Open_FragmentBB_button).visibility = View.GONE

    }
}
