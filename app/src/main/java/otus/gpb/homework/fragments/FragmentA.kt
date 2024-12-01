package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {
    lateinit var button: Button
    lateinit var textView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.buttonAA)
        textView = view.findViewById(R.id.text)
        button.setOnClickListener {
            it.visibility = GONE
            textView.visibility = GONE
            childFragmentManager
                .beginTransaction()
                .add(R.id.container, FragmentAA().apply { arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor()) })
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val backCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount == 1) {
                    button.visibility = VISIBLE
                    textView.visibility = VISIBLE
                }
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                    return
                }
                if (childFragmentManager.backStackEntryCount > 1)
                    parentFragmentManager.popBackStack()
                else
                    requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, backCallback)
    }
}