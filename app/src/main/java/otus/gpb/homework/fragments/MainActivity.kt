package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val onBackPressedCallback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount == 1)
                    binding.buttonFragmentA.visibility = View.VISIBLE
                // проверка на наличие фрагментов в BackStack
                if (supportFragmentManager.backStackEntryCount > 0) {
                    // Удаление последнего фрагмента из стека
                    supportFragmentManager.popBackStackImmediate()
                } else {

                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        binding.buttonFragmentA.setOnClickListener {
            it.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, FragmentA())
                .addToBackStack(null)
                .commit()
        }
    }
}