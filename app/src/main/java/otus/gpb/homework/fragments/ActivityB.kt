package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container_b,
                    FragmentBA.newInstance(ColorGenerator.generateColor()),
                    FRAGMENT_BA_TAG
                )
                .commit()
            Configuration.ORIENTATION_LANDSCAPE -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container_ba,
                        FragmentBA.newInstance(ColorGenerator.generateColor()),
                        FRAGMENT_BA_TAG
                    )
                    .replace(
                        R.id.fragment_container_bb,
                        FragmentBB()
                    )
                    .commit()
            }
        }
    }
}