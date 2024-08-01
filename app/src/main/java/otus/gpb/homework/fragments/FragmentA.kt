package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController

class FragmentA : Fragment(R.layout.fragment_a) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
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
        val buttonFragmentAA = view.findViewById<Button>(R.id.buttonFragmentAA)
        val fragmentAA = FragmentAA()
        val bundle = Bundle()
        buttonFragmentAA.setOnClickListener {
            bundle.putInt("color", ColorGenerator.generateColor())
            fragmentAA.arguments = bundle
            childFragmentManager.beginTransaction()
                .replace(R.id.container_fragmentA, fragmentAA)
                .addToBackStack(null)
                .commit()
        }
    }
}