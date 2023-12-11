package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.findFragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import otus.gpb.homework.fragments.viewmodels.FragmentAaViewModel
import java.lang.IllegalStateException
import kotlin.properties.Delegates

class ActivityA : AppCompatActivity() {

    private val fragmentA: FragmentA = FragmentA()
    private val fragmentAaViewModel: FragmentAaViewModel by viewModels()
    private val fragmentAbViewModel: FragmentAaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerA, fragmentA)
            .commit()
        val callback = object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                if (fragmentA.childFragmentManager.backStackEntryCount > 0) {
                    fragmentA.childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }
}