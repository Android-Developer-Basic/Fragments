package otus.gpb.homework.fragments

import FragmentBA
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Устройство находится в альбомной ориентации
            findViewById<FrameLayout>(R.id.fragment_container2).visibility = View.VISIBLE
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentBA())
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container2, FragmentBB())
                .commit()
        } else {
            // Устройство находится в портретной ориентации
            findViewById<FrameLayout>(R.id.fragment_container2).visibility = View.GONE
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentBA())
                    .commit()
            }
        }

        // Прослушиваем результаты от FragmentBB
        supportFragmentManager.setFragmentResultListener(
            "colorRequestKey",
            this
        ) { requestKey, result ->
            if (requestKey == "colorRequestKey") {
                val color = result.getInt("color", Color.WHITE)
                val fragmentBA = supportFragmentManager.findFragmentById(R.id.fragment_container) as? FragmentBA
                fragmentBA?.updateBackgroundColor(color)
            }
        }
    }
}