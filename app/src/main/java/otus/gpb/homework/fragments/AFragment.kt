package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback

class AFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.call_fragment_a_btn).setOnClickListener {
            (requireActivity() as Navigator)
                .callNextFragment(AAFragment.newInstance(ColorGenerator.generateColor()))
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val host = requireActivity()

                if (host.supportFragmentManager.backStackEntryCount == 1) {
                    host.finish()
                } else {
                    host.supportFragmentManager.popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}