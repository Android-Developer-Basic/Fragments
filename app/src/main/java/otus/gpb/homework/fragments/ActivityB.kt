package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityB: AppCompatActivity() {

    private val fragmentBA = FragmentBA()
    private val fragmentBB = FragmentBB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val fm = supportFragmentManager.beginTransaction()
        fm.add(R.id.containerBA, fragmentBB)
        fm.add(R.id.containerBB, fragmentBA)
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            fm.hide(fragmentBB)
        }
        fm.commit()
    }

    fun getFragmentBA() = fragmentBA
    fun getFragmentBB() = fragmentBB
}