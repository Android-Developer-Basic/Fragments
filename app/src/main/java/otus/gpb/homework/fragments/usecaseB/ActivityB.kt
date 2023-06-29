package otus.gpb.homework.fragments.usecaseB

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.R

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        Log.d("app", "ActivityB")

        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.activity_b_main_frame, FragmentBA())
                .commit()
            Log.d("app", "fragment_ba on view")
        }
    }

}