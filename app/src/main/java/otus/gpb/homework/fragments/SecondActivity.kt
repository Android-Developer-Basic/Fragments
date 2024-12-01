package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        if (findViewById<LinearLayout>(R.id.layout).orientation == LinearLayout.VERTICAL)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, FragmentBA().apply { arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor()) })
                .commit()
        else
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container1, FragmentBA().apply { arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor()) })
                .replace(R.id.container2, FragmentBB().apply { arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor()) })
                .commit()
    }
}