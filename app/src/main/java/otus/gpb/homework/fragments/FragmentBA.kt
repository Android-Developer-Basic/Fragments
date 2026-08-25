package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentBA : Fragment(R.layout.fragment_ba) {

    private var currentColor: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentColor = savedInstanceState?.takeIf { it.containsKey(STATE_COLOR) }
            ?.getInt(STATE_COLOR)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentColor?.let(view::setBackgroundColor)

        parentFragmentManager.setFragmentResultListener(
            COLOR_REQUEST_KEY,
            viewLifecycleOwner,
        ) { _, bundle ->
            bundle.getInt(COLOR_RESULT_KEY).let { color ->
                currentColor = color
                view.setBackgroundColor(color)
            }
        }

        val openButton = view.findViewById<View>(R.id.open_fragment_bb_button)
        openButton.visibility = if (isLandscape()) View.GONE else View.VISIBLE
        openButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_b_primary_container,
                    FragmentBB.newInstance(closeAfterSending = true),
                    FRAGMENT_BB_PORTRAIT_TAG,
                )
                .addToBackStack(FRAGMENT_BB_PORTRAIT_TAG)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        currentColor?.let { outState.putInt(STATE_COLOR, it) }
    }

    private fun isLandscape(): Boolean =
        resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    companion object {
        const val COLOR_REQUEST_KEY = "color_request"
        const val COLOR_RESULT_KEY = "color_result"

        private const val STATE_COLOR = "current_color"
        private const val FRAGMENT_BB_PORTRAIT_TAG = "fragment_bb_portrait"
    }
}