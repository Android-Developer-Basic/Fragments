package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button1.setOnClickListener(){
            val intent = ActivityA.newIntent(this)
            startActivity(intent)
        }
        binding.button2.setOnClickListener(){
            val intent = ActivityB.newIntent(this)
            startActivity(intent)
        }
    }
}