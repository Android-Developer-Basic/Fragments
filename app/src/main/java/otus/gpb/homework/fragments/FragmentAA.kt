package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class FragmentAA : Fragment() {

    private val viewModel by activityViewModels<FragmentViewModel>()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fragmentAAcolor.value?.let {
            view.findViewById<View>(R.id.fragment_aa_container)?.setBackgroundColor(
                it
            )
        }
        view.findViewById<Button>(R.id.start_fragment_ab_btn).setOnClickListener {
            viewModel.setFragmentABcolor(ColorGenerator.generateColor())
            startFragmentAB()
        }
    }

    private fun startFragmentAB() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_a_container, FragmentAB())
            .addToBackStack(null)
            .commit()
    }
}