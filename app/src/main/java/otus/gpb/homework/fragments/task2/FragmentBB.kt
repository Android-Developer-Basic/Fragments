package otus.gpb.homework.fragments.task2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentBB : Fragment(R.layout.fragment_layout) {

    private lateinit var hostInterActor: HostInterActor
    override fun onAttach(context: Context) {
        super.onAttach(context)
        hostInterActor = context as? HostInterActor
            ?: error("MainActivity2 must implement HostInterActor")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_title).apply {
            text = this@FragmentBB::class.java.simpleName
            arguments?.getInt(ARG_COLOR)?.let { setTextColor(it)}
        }

        view.findViewById<Button>(R.id.frag_open_button).apply {
            text = "Send Color to BA"

            var buttonColor = ColorGenerator.generateColor()
            setBackgroundColor(buttonColor)

            setOnClickListener {
                parentFragmentManager
                    .setFragmentResult(
                        FragmentBA.ARG_RESULT_KEY, bundleOf(FragmentBA.RESULT_VALUE to buttonColor)
                    )
                if (hostInterActor.isInLandscapeMode()) {
                    buttonColor = ColorGenerator.generateColor()
                    setBackgroundColor(buttonColor)
                } else {
                    findNavController().navigateUp()
                }
            }
        }
    }
    companion object {
        const val ARG_COLOR = "background color"
    }
}