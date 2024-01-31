package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


class FragmentA : Fragment(R.layout.fragment_a) {

    private lateinit var buttonOpenFragmentAA: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonOpenFragmentAA = view.findViewById(R.id.buttonOpenFragmentAA)
        buttonOpenFragmentAA.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_aa, FragmentAA.withArgs(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
            buttonOpenFragmentAA.visibility = View.GONE
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupOnBackPressedCallback()
    }

    private fun setupOnBackPressedCallback() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
}
