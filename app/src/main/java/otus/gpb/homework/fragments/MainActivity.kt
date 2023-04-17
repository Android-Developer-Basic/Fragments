package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

const val SWIPE = "Main layout is swiped"
const val OPEN_FRAGMENT_AB = "Open fragment AB"
const val OPEN_FRAGMENT_BB = "Open fragment BB"
const val HIDE_BUTTON = "Hide button"
const val SHOW_BUTTON = "Show button"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var buttonX:Float = 0f
    private val fragmentData: FragmentsDataVM by viewModels()
    private lateinit var fragmentA:FragmentA


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonX = binding.buttonContainer.x
        fragmentA = FragmentA(this)


        binding.button.setOnClickListener {
            fragmentData.data.value = SWIPE
            binding.buttonContainer.apply {
                SwipeView(this, 500, AccelerateInterpolator()).swipe(this.x, -1 * this.width.toFloat())
                }
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_activity_layout, fragmentA, "fragmentA")
                    .commit()

            }

        binding.button2.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

    }
}