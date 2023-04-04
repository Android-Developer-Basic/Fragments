package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment() {

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
                parentFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container_aa,
                        newInstance(ColorGenerator.generateColor(), null)
                    )
                    .addToBackStack(null)
                    .commit()
            }
        } else {
            view.findViewById<Button>(R.id.fragment_button)?.visibility = View.INVISIBLE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(backColor: Int, buttonText: String?) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(BACK_COLOR, backColor)
                    putString(BUTTON_TEXT, buttonText)
                }
            }
    }
}