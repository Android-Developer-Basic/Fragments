package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_activity)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerBA, FragmentBA())
            .commit()
    }
}
