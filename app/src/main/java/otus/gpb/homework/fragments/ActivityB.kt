package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        determineOrientation()
    }

    private fun determineOrientation() {
        val fragmentContainerB: FragmentContainerView? = findViewById(R.id.fragment_b)
        if (fragmentContainerB != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_b, FragmentBA())
                .addToBackStack(null)
                .commit()
        }
        val fragmentContainerBA: FragmentContainerView? = findViewById(R.id.fragment_ba)
        val fragmentContainerBB: FragmentContainerView? = findViewById(R.id.fragment_bb)
        if (fragmentContainerBA != null && fragmentContainerBB != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba, FragmentBA())
                .replace(R.id.fragment_bb, FragmentBB())
                .commit()
        }
    }
}