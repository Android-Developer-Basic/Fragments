package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentBB : Fragment(R.layout.fragment_bb) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
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
        val buttonFragmentBB = view.findViewById<Button?>(R.id.button_send_color)
        buttonFragmentBB.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("color", ColorGenerator.generateColor())
            requireActivity().supportFragmentManager
                .setFragmentResult("requestKey", bundle)
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
