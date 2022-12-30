package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import otus.gpb.homework.fragments.databinding.ActivityTaskBBinding

class TaskB : AppCompatActivity() {

    private lateinit var binding: ActivityTaskBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (!isTabletView()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BAFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_a, BAFragment())
                .replace(R.id.fragment_container_b, BBFragment())
                .commit()
        }
    }

    private fun isTabletView(): Boolean {
        return binding.fragmentContainer == null
    }
}