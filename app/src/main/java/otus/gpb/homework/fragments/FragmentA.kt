package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


class FragmentA : Fragment(), ParentFragmentListener {

    private lateinit var openChildFragmentAAButton: Button
    private lateinit var onBackPressedCallback: OnBackPressedCallback

    private val childBackStackListener = FragmentManager.OnBackStackChangedListener {
        updateOpenChildButtonVisibility()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_parent_a, container, false)

        openChildFragmentAAButton = view.findViewById(R.id.button_open_fragment_aa)

        openChildFragmentAAButton.setOnClickListener {
            openChildFragmentAA()
        }

        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                    isEnabled = true
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )

        childFragmentManager.addOnBackStackChangedListener(childBackStackListener)
        updateOpenChildButtonVisibility()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        childFragmentManager.removeOnBackStackChangedListener(childBackStackListener)
    }

    private fun updateOpenChildButtonVisibility() {
        val hasChildFragment =
            childFragmentManager.findFragmentById(R.id.parent_fragment_a_child_container) != null
        val isChildBackStackEmpty = childFragmentManager.backStackEntryCount == 0

        if (hasChildFragment && isChildBackStackEmpty) {
        } else if (!hasChildFragment && isChildBackStackEmpty) {
            openChildFragmentAAButton.visibility = View.VISIBLE
        } else {
            openChildFragmentAAButton.visibility = View.GONE
        }

        openChildFragmentAAButton.visibility =
            if (childFragmentManager.backStackEntryCount == 0 && childFragmentManager.findFragmentById(
                    R.id.parent_fragment_a_child_container
                ) == null
            ) View.VISIBLE else View.GONE
        openChildFragmentAAButton.visibility =
            if (childFragmentManager.backStackEntryCount == 0) View.VISIBLE else View.GONE
    }

    private fun openChildFragmentAA() {
        val randomColor = ColorGenerator.generateColor()
        val childFragmentAA = ChildFragmentAA.newInstance(randomColor)
        childFragmentManager.beginTransaction()
            .replace(R.id.parent_fragment_a_child_container, childFragmentAA)
            .addToBackStack("ChildFragmentAA")
            .commit()
        openChildFragmentAAButton.visibility = View.GONE
    }

    private fun openChildFragmentAB() {
        val randomColor = ColorGenerator.generateColor()
        val childFragmentAB = ChildFragmentAB.newInstance(randomColor)
        childFragmentManager.beginTransaction()
            .replace(R.id.parent_fragment_a_child_container, childFragmentAB)
            .addToBackStack("ChildFragmentAB")
            .commit()
    }

    override fun onOpenChildFragmentABClicked() {
        openChildFragmentAB()
    }
}
