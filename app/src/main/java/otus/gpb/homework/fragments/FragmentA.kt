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
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.go_to_fragment_AA).setOnClickListener {
            val color = ColorGenerator.generateColor()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentAA.newInst(color))
                .addToBackStack(null)
                .commit()
        }

    val host = requireActivity()
    val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (parentFragmentManager.fragments.count() > 1)
                parentFragmentManager.popBackStack()
            else
                host.finish()
        }
    }
        host.onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}