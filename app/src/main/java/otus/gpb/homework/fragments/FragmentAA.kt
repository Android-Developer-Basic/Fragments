package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class FragmentAA : Fragment() {

    private val viewModel by activityViewModels<FragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.colorValue.value?.let {
            view.findViewById<View>(R.id.fragment_aa_container)?.setBackgroundColor(
                it
            )
        }
        view.findViewById<Button>(R.id.start_fragment_ab_btn).setOnClickListener {
            viewModel.setColor(ColorGenerator.generateColor())
            findNavController().navigate(R.id.action_fragmentAA_to_fragmentAB)
        }
    }
}