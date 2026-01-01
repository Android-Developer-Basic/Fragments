package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_a, FragmentA(), "FragmentA_Tag").commit()
        }

        onBackPressedDispatcher.addCallback(this) {
            val fragmentA = supportFragmentManager.findFragmentByTag("FragmentA_Tag")
            val childStackCount = fragmentA?.childFragmentManager?.backStackEntryCount ?: 0

            if (childStackCount > 0) {
                fragmentA?.childFragmentManager?.popBackStack()
            } else {
                finish()
            }
        }
    }
}