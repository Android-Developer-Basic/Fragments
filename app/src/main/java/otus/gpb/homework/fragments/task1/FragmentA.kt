package otus.gpb.homework.fragments.task1

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentA : Fragment(R.layout.fragment_layout) {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 1) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.frag_open_button).apply {

            text = context.getString(R.string.open_frag_button, FragmentAA.TAG)

            setOnClickListener {
                childFragmentManager.beginTransaction()
                    .add(
                        R.id.frag_container,
                        FragmentAA.getInstance(ColorGenerator.generateColor())
                    )
                    .addToBackStack(FragmentAA.TAG)
                    .commit()
            }
        }

        view.findViewById<TextView>(R.id.frag_title).apply {
            text = context.getString(R.string.frag_name, TAG)
        }
    }

    companion object {
        const val TAG = "Fragment_A"
    }
}