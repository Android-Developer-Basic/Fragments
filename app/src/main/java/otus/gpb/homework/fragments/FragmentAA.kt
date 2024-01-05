package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentAA: Fragment(R.layout.fragment_aa) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { view.setBackgroundColor(it.getInt(COLOR)) }
        val buttonOpenFragmentAB = view.findViewById<Button>(R.id.buttonOpenFragmentAB)
        buttonOpenFragmentAB.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.container_ab, FragmentAB.withArgs(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
            buttonOpenFragmentAB.visibility = View.GONE
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

    companion object {
        private const val COLOR = "color"

        fun withArgs(value: Int) : FragmentAA {
            val fragment = FragmentAA()
            val arguments = Bundle()
            arguments.putInt(COLOR, value)
            fragment.arguments = arguments
            return  fragment
        }
    }
}