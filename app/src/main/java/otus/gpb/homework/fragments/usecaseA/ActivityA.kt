package otus.gpb.homework.fragments.usecaseA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import otus.gpb.homework.fragments.R

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        Log.d("app", "ActivityA")

        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_a_main_frame, FragmentA())
                .commit()
            Log.d("app", "fragment_a on view")
        }
    }
}