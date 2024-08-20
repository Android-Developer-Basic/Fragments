package otus.gpb.homework.fragments.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R


class FragmentBB : Fragment(R.layout.fragment_b_b) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val count = parentFragmentManager.backStackEntryCount
                    parentFragmentManager.popBackStack()
                    if (count == 0) {
                        requireActivity().finish()
                    }
                }
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById(R.id.buttonSendColor)

        button.setOnClickListener() {
            val bundle = Bundle()
            bundle.putInt("color", ColorGenerator.generateColor())
            requireActivity().supportFragmentManager
                .setFragmentResult("request_key", bundle)
        }
    }
}