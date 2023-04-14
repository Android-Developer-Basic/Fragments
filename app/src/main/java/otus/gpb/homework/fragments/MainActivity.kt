package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

const val SWIPED = "Main layout is swiped"
const val FIRST_FRAGMENT_CLOSING = "First fragment is closed"
const val  BACK_CLICKED = "Back was pressed"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var buttonX:Float = 0f
    private val fragmentData: FragmentsDataVM by viewModels()
    private val fragmentA by lazy { FragmentA() }
    private val fragmentManager:FragmentManager by lazy {
        supportFragmentManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonX = binding.buttonContainer.x
        val openFragmentABtn = binding.openFragmentABtn
        openFragmentABtn.setOnClickListener {
            fragmentData.data.value = SWIPED
            binding.buttonContainer.apply {
                SwipeView(this, 1000, AccelerateInterpolator()).swipe(this.x, -1*this.width.toFloat())
            }

            fragmentManager
                .beginTransaction()
                .replace(R.id.main_activity_layout, fragmentA)
                .addToBackStack("stack-1")
                .commit()

        }

        fragmentData.data.observe(this@MainActivity as LifecycleOwner){
            when(it){
                FIRST_FRAGMENT_CLOSING -> SwipeView(binding.buttonContainer, 1000, AccelerateInterpolator())
                        .swipe(binding.buttonContainer.x, buttonX)
            }
        }


    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        fragmentData.data.value = BACK_CLICKED
        super.getOnBackPressedDispatcher()
    }
}