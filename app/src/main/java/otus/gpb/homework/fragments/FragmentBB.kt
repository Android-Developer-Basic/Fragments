package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentBB : Fragment(R.layout.fragment_bb) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.send_color_button).setOnClickListener {
            parentFragmentManager.setFragmentResult(
                FragmentBA.COLOR_REQUEST_KEY,
                Bundle().apply {
                    putInt(FragmentBA.COLOR_RESULT_KEY, ColorGenerator.generateColor())
                },
            )

            if (requireArguments().getBoolean(ARG_CLOSE_AFTER_SENDING)) {
                parentFragmentManager.popBackStack()
            }
        }
    }

    companion object {
        private const val ARG_CLOSE_AFTER_SENDING = "close_after_sending"

        fun newInstance(closeAfterSending: Boolean) = FragmentBB().apply {
            arguments = Bundle().apply {
                putBoolean(ARG_CLOSE_AFTER_SENDING, closeAfterSending)
            }
        }
    }
}