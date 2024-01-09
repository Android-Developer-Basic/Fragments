package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentA: Fragment(R.layout.fragment_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonOpenFragmentAA = view.findViewById<Button>(R.id.buttonOpenFragmentAA)
        buttonOpenFragmentAA.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.container_aa, FragmentAA.withArgs(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
            buttonOpenFragmentAA.visibility = View.GONE
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                }
                else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
}