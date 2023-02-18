package otus.gpb.homework.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_open_fr_aa).setOnClickListener {
            val fragmentAA = FragmentAA()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentAA, "fragment_aa")
                .addToBackStack(null)
                .commit()
        }

        val callback: OnBackPressedCallback = object : OnBackPressedCallback( true) {
            override fun handleOnBackPressed() {
                val count = parentFragmentManager.backStackEntryCount
                if (count > 1)
                    parentFragmentManager.popBackStack()
                else
                    requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }





}
