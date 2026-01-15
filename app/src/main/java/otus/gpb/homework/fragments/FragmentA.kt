package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentA : Fragment() {

    private fun generateBackgroundColor() = ColorGenerator.generateColor()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 1) childFragmentManager.popBackStack()
                else {
                    isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.fragment_a_btn).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_aa, FragmentAA.newInstance(generateBackgroundColor()))
                .addToBackStack(null)
                .commit()
        }
    }

    fun createFragmentAB() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_aa, FragmentAB.newInstance(generateBackgroundColor()))
            .addToBackStack(null)
            .commit()
    }
}