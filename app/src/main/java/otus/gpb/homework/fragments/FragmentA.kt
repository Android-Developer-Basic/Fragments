package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    private lateinit var button: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount == 1) {
                    activity?.title = getString(R.string.fragment_a)
                    button.visibility = VISIBLE
                }
                if (childFragmentManager.backStackEntryCount >= 1) {
                    childFragmentManager.popBackStack()
                } else {
                    requireActivity().finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.fragment_a)

        button = view.findViewById(R.id.button_aa)
        button.setOnClickListener {
            button.visibility = GONE
            childFragmentManager
                .beginTransaction()
                .replace(R.id.container, FragmentAA().apply {
                    arguments = bundleOf(KEY_COLOR to ColorGenerator.generateColor())
                })
                .addToBackStack(null)
                .commit()
        }
    }
}