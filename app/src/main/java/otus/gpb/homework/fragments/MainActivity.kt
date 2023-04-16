package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

const val SWIPED = "Main layout is swiped"
const val OPEN_FRAGMENT_AB = "Open fragment AB"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var buttonX:Float = 0f
    private val fragmentData: FragmentsDataVM by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentA = FragmentA()
        buttonX = binding.buttonContainer.x
        binding.button.setOnClickListener {
                fragmentData.data.value = SWIPED
                binding.buttonContainer.apply {
                    SwipeView(this, 500, AccelerateInterpolator()).swipe(
                        this.x,
                        -1 * this.width.toFloat()
                    )
                }
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_activity_layout, fragmentA)
                    .commit()

            }

    }
}