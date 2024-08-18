package otus.gpb.homework.fragments

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import otus.gpb.homework.fragments.screens.FragmentBA
import otus.gpb.homework.fragments.screens.FragmentBB

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val orientation = resources.configuration.orientation

        if (orientation == ORIENTATION_PORTRAIT) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_ba, FragmentBA().apply {
                    arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor())
                })
                .commit()
        } else if (orientation == ORIENTATION_LANDSCAPE) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_ba, FragmentBA().apply {
                    arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor())
                })
                .add(R.id.container_bb, FragmentBB().apply {
                    arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor())
                })
                .commit()
        }
    }
}