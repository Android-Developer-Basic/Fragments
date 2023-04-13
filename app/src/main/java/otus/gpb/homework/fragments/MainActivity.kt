package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

const val SWIPED = "Main layout is swiped"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val btnCoords = arrayOf(0F,0F)
    private val fragmentData:FragmentsDataVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val openFragmentABtn = binding.openFragmentABtn
            openFragmentABtn.setOnClickListener {
                fragmentData.data.value = SWIPED
                SwipeView(binding.openFragmentABtn, 1000, AccelerateInterpolator()).swipe()

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_activity_layout, FragmentA.newInstance())
                    .addToBackStack("stack-1")
                    .commit()

            }


    }



}