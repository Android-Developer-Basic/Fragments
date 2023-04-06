package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            view.setBackgroundColor(ColorGenerator.generateColor())

            view.findViewById<Button>(R.id.button_open_frgAA).apply {
                setOnClickListener {
                    val key = "FragmentAA"
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_AA, FragmentAA::class.java, bundleOf("color" to ColorGenerator.generateColor()), key)
                        .addToBackStack(key)
                        .commit()
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    if (childFragmentManager.backStackEntryCount > 0)
                        childFragmentManager.popBackStack()
                    else {
                        isEnabled = false
                        activity?.onBackPressed()
                    }
                }
            }
        )

    }

}
