package otus.gpb.homework.fragments.task2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import otus.gpb.homework.fragments.R

class ActivityTask2 : AppCompatActivity() {
    private var fragmentContainerRight: FragmentContainerView? = null
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            } else {
                isEnabled = false
                onBackPressed()
            }
        }

    }
    private var color = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_2)

        color = savedInstanceState?.getInt("color") ?:0
        Log.e("onCreateColor", color.toString())
        onBackPressedDispatcher.addCallback(this, callback)

        fragmentContainerRight = findViewById(R.id.fragmentContainerRight)


        if (isOnePaneMode()) {
            val fragmentBA = FragmentBA.newInstance(false, color)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerLeft, fragmentBA)
                .addToBackStack("addFragmentBA")
                .commit()
            listenerFragmentBA()
        } else {
            val fragmentBA = FragmentBA.newInstance(true, color)
            val fragmentBB = FragmentBB.newInstanceActivity()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerLeft, fragmentBA)
                .replace(R.id.fragmentContainerRight, fragmentBB)
                .commit()
            listenerFragmentBA()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("color", color)
    }

    fun listenerFragmentBA(){
        supportFragmentManager.setFragmentResultListener(
            "color_key",
            this
        ) { requestKey, bundle ->
            val result = bundle.getInt("color")
            color = result
            Log.e("ActivityTask2Color",color.toString())
        }
    }


    private fun isOnePaneMode(): Boolean {
        return fragmentContainerRight == null
    }

    companion object {
        fun newIntentActivityTask2(context: Context): Intent {
            return Intent(context, ActivityTask2::class.java)
        }
    }
}