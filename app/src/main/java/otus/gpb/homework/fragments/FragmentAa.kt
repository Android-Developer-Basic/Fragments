package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import otus.gpb.homework.fragments.viewmodels.FragmentAaViewModel
import otus.gpb.homework.fragments.viewmodels.FragmentAbViewModel

class FragmentAa : Fragment(R.layout.fragment_aa) {

    private val fragmentAaViewModel: FragmentAaViewModel by activityViewModels()
    private val fragmentAbViewModel: FragmentAbViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentAaViewModel.color.observe(viewLifecycleOwner) {
            view.setBackgroundColor(it)
        }
        view.findViewById<Button>(R.id.openFragmentAbButton).setOnClickListener {
            fragmentAbViewModel.setColor(ColorGenerator.generateColor())
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerAb, FragmentAb(), FragmentAb::class.java.simpleName)
                .addToBackStack(FragmentAb::class.java.simpleName)
                .commit()
        }
    }
}