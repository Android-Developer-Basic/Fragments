package otus.gpb.homework.fragments.task2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentBA : Fragment(R.layout.fragment_layout) {

    private var color: Int = 0xFFFFFF

    private lateinit var hostInterActor: HostInterActor
    override fun onAttach(context: Context) {
        super.onAttach(context)
        hostInterActor = context as? HostInterActor ?: error("MainActivity2 must implement HostInterActor")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (null != savedInstanceState) {
            color = savedInstanceState.getInt("color", color)
        }
        view.setBackgroundColor(color)

        view.findViewById<TextView>(R.id.frag_title).text = this::class.java.simpleName

        val button = view.findViewById<Button>(R.id.frag_open_button)
        if (!hostInterActor.isInLandscapeMode()) {
            button.apply {
                val buttonColor = ColorGenerator.generateColor()
                setBackgroundColor(buttonColor)

                text = context.getString(R.string.open_frag_button, "Fragment BB")

                setOnClickListener {
//                    val bundle = bundleOf(FragmentBB.ARG_COLOR to buttonColor)
//                    findNavController().navigate(R.id.action_fragment_ba_to_fragment_bb, bundle)

                    val action = FragmentBADirections.actionFragmentBaToFragmentBb(buttonColor)
                    findNavController().navigate(action)
                }
            }
        } else {
            button.visibility = View.GONE
        }

        parentFragmentManager.setFragmentResultListener(ARG_RESULT_KEY, this)  { _, bundle ->
            color = bundle.getInt(RESULT_VALUE)
            view.setBackgroundColor(color)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("color", color)
    }

    companion object {
        const val ARG_RESULT_KEY = "color result"
        const val RESULT_VALUE = "color value"
    }
}