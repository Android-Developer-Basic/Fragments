package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class FragmentAA : Fragment() {

    private var colorBackground: Int = UNKNOWN_COLOR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParam()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState?.getInt("KEY_COLOR") == null) {
            view.setBackgroundColor(colorBackground)
        } else{
            view.setBackgroundColor(savedInstanceState.getInt("KEY_COLOR"))
        }

        val button = view.findViewById<Button>(R.id.openAB)
        button.setOnClickListener {
            val fragmentAB = FragmentAB.fragmentABInstance(ColorGenerator.generateColor())
            parentFragmentManager.beginTransaction()
                .apply {
                    it.visibility = View.GONE
                }
                .replace(R.id.childContainer, fragmentAB)
                .addToBackStack("")
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.apply {
            putInt("KEY_COLOR", colorBackground)
        }
        super.onSaveInstanceState(outState)
    }


    private fun parseParam() {
        val args = requireArguments()
        if (!args.containsKey(COLOR_BACKGROUND_KEY)) {
            throw Exception("Don't color")
        }
        colorBackground = args.getInt(COLOR_BACKGROUND_KEY)
    }


    companion object {
        private val UNKNOWN_COLOR = 0
        private val COLOR_BACKGROUND_KEY = "colorBackground"
        fun fragmentAAInstance(colorBackground: Int): FragmentAA {
            return FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_BACKGROUND_KEY, colorBackground)
                }
            }
        }
    }
}