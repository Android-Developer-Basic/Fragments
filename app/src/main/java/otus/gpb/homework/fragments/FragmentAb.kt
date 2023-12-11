package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import otus.gpb.homework.fragments.viewmodels.FragmentAbViewModel

class FragmentAb : Fragment(R.layout.fragment_ab) {

    private val fragmentAbViewModel: FragmentAbViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentAbViewModel.color.observe(viewLifecycleOwner) {
            view.setBackgroundColor(it)
        }
    }
}