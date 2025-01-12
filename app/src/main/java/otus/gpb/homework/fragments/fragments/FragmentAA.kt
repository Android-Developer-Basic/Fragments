package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentAA : Fragment(R.layout.fragment_a_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = arguments?.getInt("color")

        if (color != null) {
            this.view?.setBackgroundColor(color)
        }

        val bundle = Bundle()
        bundle.putInt("color", ColorGenerator.generateColor())
        val fragmentAB = FragmentAB()
        fragmentAB.arguments = bundle

        view.findViewById<Button>(R.id.openFragmentAB).setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerAB, fragmentAB)
                .addToBackStack("fragmentAA")
                .commit()
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}