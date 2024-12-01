package otus.gpb.homework.fragments

import android.content.Context
import android.icu.util.BuddhistCalendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback

class FragmentA : Fragment(R.layout.fragment_a) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this,
            object: OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val count = childFragmentManager.backStackEntryCount
                        childFragmentManager.popBackStack()
                    if (count == 0) {
                        requireActivity().finish()
                    }
                }
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentAA = FragmentAA()
        val button: Button = view.findViewById(R.id.buttonToFragmentAA)
        val bundle = Bundle()
        button.setOnClickListener() {
            bundle.putInt("color", ColorGenerator.generateColor())
            fragmentAA.arguments = bundle
            childFragmentManager.beginTransaction().replace(R.id.fragment_container_a, fragmentAA).addToBackStack(null).commit()
        }
    }

}

