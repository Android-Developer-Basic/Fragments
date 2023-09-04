package com.rg.secondapp

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.rg.secondapp.databinding.FragmentBbBinding

class FragmentBB : Fragment() {
    val binding by lazy { FragmentBbBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*arguments?.getInt("Color")?.let { color ->
            view.setBackgroundColor(color)
        }*/

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

        binding.buttonSendColor.setOnClickListener {
            parentFragmentManager.setFragmentResult("colorBB", Bundle().apply {
                putInt("Color", ColorGenerator.generateColor())
            })
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                parentFragmentManager.popBackStack()
        }

    }
}