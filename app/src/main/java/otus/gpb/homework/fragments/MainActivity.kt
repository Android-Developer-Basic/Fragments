package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openFragmentA = findViewById<Button>(R.id.open_fragment_a_button)

        val onBackPressedCallback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount == 1)
                    openFragmentA.visibility = View.VISIBLE
                // проверка на наличие фрагментов в BackStack
                if (supportFragmentManager.backStackEntryCount > 0) {
                    // Удаление последнего фрагмента из стека
                    supportFragmentManager.popBackStackImmediate()
                } else {

                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        openFragmentA.setOnClickListener {
            it.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentA())
                .addToBackStack(null)
                .commit()
        }
    }
}