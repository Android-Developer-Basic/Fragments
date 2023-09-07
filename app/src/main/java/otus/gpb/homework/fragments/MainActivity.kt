package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val orientation = resources.configuration.orientation

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentAButton.setOnClickListener {


            binding.startContainer.visibility = View.VISIBLE
            binding.endContainer?.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.start_container, AFragment.newInstance())
                .addToBackStack(null)
//                .setReorderingAllowed(true)
                .commit()
        }

        binding.fragmentBaButton.setOnClickListener {

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                binding.startContainer.visibility = View.VISIBLE
                binding.endContainer?.visibility = View.VISIBLE

                supportFragmentManager.beginTransaction()
                    .replace(R.id.start_container, BAFragment.newInstance())
                    .replace(R.id.end_container, BBFragment.newInstance())
                    .addToBackStack(null)
                    .commit()

            } else {
                binding.startContainer.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction()
                    .replace(R.id.start_container, BAFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }

        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                if (supportFragmentManager.backStackEntryCount > 1) {
                    supportFragmentManager.popBackStack()
                } else {
                    binding.endContainer?.visibility = View.GONE
                    binding.startContainer.visibility = View.GONE
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }

}