package com.rg.secondapp

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.rg.secondapp.databinding.FragmentBaBinding

class FragmentBA : Fragment() {
    val binding by lazy { FragmentBaBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt("Color")?.let { color ->
            view.setBackgroundColor(color)
        }

/*        binding.buttonFragmentBB.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_a, FragmentAB().apply {
                    arguments = Bundle().apply {
                        putInt("Color", ColorGenerator.generateColor())
                    }
                })
                addToBackStack(null)
            }.commit()
        }*/

        when(resources.configuration.orientation){
            Configuration.ORIENTATION_LANDSCAPE -> { //Альбомная ориентация
                binding.buttonFragmentBB.visibility = View.GONE
            }
            Configuration.ORIENTATION_PORTRAIT -> { //Портретная ориентация
                binding.buttonFragmentBB.visibility = View.VISIBLE
                binding.buttonFragmentBB.setOnClickListener {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_1, FragmentBB())
                        .addToBackStack(null)
                        .commit()
                }
                val returnBBKey = "colorBB"
                parentFragmentManager.setFragmentResultListener(
                    returnBBKey,
                    this
                ){ requestKey, result ->
                    if(requestKey == returnBBKey){
                        setBackgroundColor(result.getInt("Color"))
                    }
                }
            }
            else -> {}
        }
    }

    fun setBackgroundColor(color: Int){
        binding.root.setBackgroundColor(color)
    }
}