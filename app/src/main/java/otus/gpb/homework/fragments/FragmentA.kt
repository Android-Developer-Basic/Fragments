package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backColor = arguments?.getInt(BACK_COLOR)
        val buttonText = arguments?.getString(BUTTON_TEXT)
        if (backColor != null) {
            view.setBackgroundColor(backColor)
        }
        if (buttonText != null) {
            view.findViewById<Button>(R.id.fragment_button).text = buttonText
            view.findViewById<Button>(R.id.fragment_button).setOnClickListener {
                childFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container_aa,
                        FragmentAA.newInstance(
                            ColorGenerator.generateColor(),
                            getString(R.string.open_ab)
                        )
                    )
                    .addToBackStack(null)
                    .commit()
            }
        } else {
            view.findViewById<Button>(R.id.fragment_button)?.visibility = View.INVISIBLE
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

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

    companion object {
        @JvmStatic
        fun newInstance(backColor: Int, buttonText: String?) =
            FragmentA().apply {
                arguments = Bundle().apply {
                    putInt(BACK_COLOR, backColor)
                    putString(BUTTON_TEXT, buttonText)
                }
            }
    }
}