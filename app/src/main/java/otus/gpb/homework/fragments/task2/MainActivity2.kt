package otus.gpb.homework.fragments.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import otus.gpb.homework.fragments.R

class MainActivity2 : AppCompatActivity(), HostInterActor {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)
    }

    override fun isInLandscapeMode(): Boolean {
        val secondFragContainer: FragmentContainerView? = findViewById(R.id.second_container)
        return secondFragContainer != null
    }
}