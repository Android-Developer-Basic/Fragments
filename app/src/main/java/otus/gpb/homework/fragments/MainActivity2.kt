package otus.gpb.homework.fragments

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import otus.gpb.homework.fragments.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val fragmentData: FragmentsDataVM by viewModels()
    private lateinit var fragmentBA: FragmentBA
    private lateinit var fragmentBB: FragmentBB
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentBA = FragmentBA()
        fragmentBB = FragmentBB()
        val activityManager = supportFragmentManager



        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                fragmentData.data.value = SHOW_BUTTON
                activityManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container1, fragmentBA)
                    .commit()
            }
            Configuration.ORIENTATION_LANDSCAPE ->{
                fragmentData.data.value = HIDE_BUTTON
                activityManager
                    .beginTransaction()
                    .replace(R.id.container1, fragmentBA)
                    .commit()
                activityManager
                    .beginTransaction()
                    .replace(R.id.container2, fragmentBB)
                    .commit()
            }
            else -> return
        }

        fragmentData.data.observe(this as LifecycleOwner){
            when(it){
                OPEN_FRAGMENT_BB -> activityManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container1, fragmentBB)
                    .commit()
            }
        }


    }
}