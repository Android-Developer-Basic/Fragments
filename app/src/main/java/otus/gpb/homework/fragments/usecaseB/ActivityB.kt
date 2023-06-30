package otus.gpb.homework.fragments.usecaseB

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.R

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        if(savedInstanceState == null) {
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.left_fragment_frame, FragmentBA())
                    .replace(R.id.right_fragment_frame, FragmentBB())
                    .commit()
                Log.d("app", "fragment - landscape on view")
            }
            else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_b_main_frame, FragmentBA())
                    .commit()
                Log.d("app", "fragment_ba - portrait on view")
            }
        }
    }
}