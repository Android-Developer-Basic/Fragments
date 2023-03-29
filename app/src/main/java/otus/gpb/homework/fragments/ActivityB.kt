package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity


class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_b_a_port, FragmentBA())
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_b_a, FragmentBA())
                .replace(R.id.fragment_b_b, FragmentBB())
                .addToBackStack(null)
                .commit()
        }
    }
}
