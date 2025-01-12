package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bundle = Bundle()
        bundle.putInt("color", ColorGenerator.generateColor())
        val fragmentAA = FragmentAA()
        fragmentAA.arguments = bundle

        view.findViewById<Button>(R.id.openFragmentAA).setOnClickListener {
            childFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerAA, fragmentAA)
                .addToBackStack("fragmentA")
                .commit()
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
               activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}