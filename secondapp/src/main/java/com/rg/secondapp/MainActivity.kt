package com.rg.secondapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentBa = FragmentBA()

        when(resources.configuration.orientation){
            Configuration.ORIENTATION_LANDSCAPE -> { //Альбомная ориентация
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container_1, fragmentBa)
                    commit()
                }
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container_2, FragmentBB())
                    commit()
                }
            }
            Configuration.ORIENTATION_PORTRAIT -> { //Портретная ориентация
                findViewById<FragmentContainerView>(R.id.fragment_container_2).visibility = View.GONE//Вьюха сруливает в отличии от INVISIBLE
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container_1, FragmentBA())
                    commit()
                }
            }
            else -> {}
        }

        val returnBBKey = "colorBB"
        supportFragmentManager.setFragmentResultListener(
            returnBBKey,
            this
        ){ requestKey, result ->
            if(requestKey == returnBBKey){
                fragmentBa.setBackgroundColor(result.getInt("Color"))
            }
        }
    }
}