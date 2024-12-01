package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        selectOrientation()
    }

    private fun selectOrientation() {
        val fragmentContainerB: FragmentContainerView? = findViewById(R.id.containerB)
        if (fragmentContainerB != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerB, FragmentBA())
                .addToBackStack(null)
                .commit()
        }
        val fragmentContainerBA: FragmentContainerView? = findViewById(R.id.containerBA)
        val fragmentContainerBB: FragmentContainerView? = findViewById(R.id.containerBB)
        if (fragmentContainerBA != null && fragmentContainerBB != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerBA, FragmentBA())
                .replace(R.id.containerBB, FragmentBB())
                .commit()
        }
    }
}