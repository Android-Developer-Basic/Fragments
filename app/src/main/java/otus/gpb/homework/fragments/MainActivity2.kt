package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var BAFragment: FragmentBA
    private lateinit var BBFragment: FragmentBB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if (savedInstanceState == null) {
            BAFragment = FragmentBA()
            BBFragment = FragmentBB()

        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.replace(R.id.BAcontainer, FragmentBA())
        transaction.replace(R.id.BB_container, FragmentBB())
        transaction.addToBackStack(null)
        transaction.commit()


    }
}
