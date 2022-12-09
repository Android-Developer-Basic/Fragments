package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity_B : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_b)
        val Fr_BA = Fragment_BA()
        if (findViewById<FrameLayout>(R.id.Fr_Port) != null)
        {
            supportFragmentManager.beginTransaction()
                .replace(R.id.Fr_Port, Fr_BA, "Fr_BA")
                .commit()
        }
        else
        {
            val Fr_BB = Fragment_BB()
            supportFragmentManager.beginTransaction()
                .replace(R.id.Fr_Fragment_BA, Fr_BA, "Fr_BA")
                .replace(R.id.Fr_Fragment_BB, Fr_BB, "Fr_BB")
                .commit()
        }
    }
}