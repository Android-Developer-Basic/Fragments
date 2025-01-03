package otus.gpb.homework.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityA: AppCompatActivity(R.layout.activity_a) {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .add(R.id.containerActivityA, FragmentMainActivityA())
            .commit()
    }
}