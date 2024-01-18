package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

class Task1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)
        startFragmentA()
    }

    private fun startFragmentA() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_container, FragmentA())
            .commit()
    }
}