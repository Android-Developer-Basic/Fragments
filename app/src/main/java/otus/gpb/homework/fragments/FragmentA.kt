package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback


class FragmentA : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val openFragmentAA =  view.findViewById<Button>(R.id.open_fragment_aa_button)

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount == 1)
                    openFragmentAA.visibility = View.VISIBLE
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStackImmediate()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)


        openFragmentAA.setOnClickListener {
            it.visibility = View.GONE
            val color = ColorGenerator.generateColor()

            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_a_container, FragmentAA().apply {
                    arguments = Bundle().apply {
                        putInt("color", color)
                    }
                })
                addToBackStack(null)
                commit()
            }
        }
    }
}