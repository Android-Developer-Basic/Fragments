package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityA: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_activity)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment())
            .commit()
    }
}