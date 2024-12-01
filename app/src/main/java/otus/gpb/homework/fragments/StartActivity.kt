package otus.gpb.homework.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import otus.gpb.homework.fragments.databinding.ActivityStartBinding
import otus.gpb.homework.fragments.first.FirstTaskActivity
import otus.gpb.homework.fragments.second.SecondTaskActivity

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.openFirstTaskButton.setOnClickListener {
            startActivity(Intent(this, FirstTaskActivity::class.java))
            finish()
        }

        binding.openSecondTaskButton.setOnClickListener {
            startActivity(Intent(this, SecondTaskActivity::class.java))
            finish()
        }
    }
}
