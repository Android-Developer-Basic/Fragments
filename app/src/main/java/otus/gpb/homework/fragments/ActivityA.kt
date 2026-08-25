package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_host)
        title = getString(R.string.task_a_title)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_host_container, FragmentA(), FRAGMENT_A_TAG)
                .commit()
        }

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val fragmentA = supportFragmentManager
                        .findFragmentByTag(FRAGMENT_A_TAG) as? FragmentA
                    val childManager = fragmentA?.childFragmentManager

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
        const val FRAGMENT_A_TAG = "fragment_a"
    }
}