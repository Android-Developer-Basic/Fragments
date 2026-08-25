package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_host)
        title = getString(R.string.task_b_title)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_host_container, FragmentB(), FRAGMENT_B_TAG)
                .commit()
        }

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val fragmentB = supportFragmentManager
                        .findFragmentByTag(FRAGMENT_B_TAG) as? FragmentB
                    val childManager = fragmentB?.childFragmentManager

                    if (childManager != null && childManager.backStackEntryCount > 0) {
                        childManager.popBackStack()
                    } else {
                        finish()
                    }
                }
            },
        )
    }

    private companion object {
        const val FRAGMENT_B_TAG = "fragment_b"
    }
}