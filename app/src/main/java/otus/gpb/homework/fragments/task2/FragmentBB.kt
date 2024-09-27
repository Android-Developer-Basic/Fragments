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
    private var buttonColor: Int = 0xFFFFFF

//    when app starts in landscape mode - throws IllegalStateException: FragmentBB has null arguments
//    private val args by navArgs<FragmentBBArgs>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        hostInterActor = context as? HostInterActor
            ?: error("MainActivity2 must implement HostInterActor")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            buttonColor = savedInstanceState.getInt("buttonColor", buttonColor)
        }

        view.findViewById<TextView>(R.id.frag_title).apply {
            text = this@FragmentBB::class.java.simpleName

            arguments?.getInt("colorArg")?.let { setTextColor(it)}

//            with "by navArgs<FragmentBBArgs>()"
//            args?.colorArg?.let { setTextColor(it)}

//            setTextColor(textColorArg)
//            arguments?.getInt(ARG_COLOR)?.let { setTextColor(it)}
        }

        view.findViewById<Button>(R.id.frag_open_button).apply {
            text = "Send Color to BA"

            buttonColor = ColorGenerator.generateColor()
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("buttonColor", buttonColor)
    }

    companion object {
        const val ARG_COLOR = "background color"
    }
}