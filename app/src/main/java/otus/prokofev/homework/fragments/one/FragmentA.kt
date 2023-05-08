package otus.prokofev.homework.fragments.one

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import otus.prokofev.homework.fragments.ColorGenerator
import otus.prokofev.homework.fragments.R

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_open_fr_aa).setOnClickListener {
            val color = ColorGenerator.generateColor()
            childFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.childFragmentContainer, FragmentAA.newInstance(color))
                .addToBackStack(null)
                .commit()
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 1) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentFragmentManager.commit {
            setPrimaryNavigationFragment(this@FragmentA)
        }
    }

}

