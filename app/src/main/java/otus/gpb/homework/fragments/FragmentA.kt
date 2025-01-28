package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        val openFragmentAAButton = view.findViewById<Button>(R.id.buttonOpenFragmentAA)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (childFragmentManager.backStackEntryCount > 0) {
                        childFragmentManager.popBackStack()
                    } else {
                        requireActivity().finish()
                    }
                }
            }
        )

        openFragmentAAButton.setOnClickListener {
            val fragmentAa = FragmentAA()
            val args = Bundle()
            args.putInt("color", ColorGenerator.generateColor())
            fragmentAa.arguments = args

            childFragmentManager.beginTransaction()
                .add(R.id.frame_layout_fragment_a, fragmentAa)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
