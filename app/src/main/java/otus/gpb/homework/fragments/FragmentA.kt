package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import otus.gpb.homework.fragments.viewmodels.FragmentAaViewModel

class FragmentA : Fragment(R.layout.fragment_a) {

    private val fragmentAaViewModel: FragmentAaViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.openFragmentAaButton).setOnClickListener {
            fragmentAaViewModel.setColor(ColorGenerator.generateColor())
            childFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerAa, FragmentAa(), FragmentAa::class.java.simpleName)
                .addToBackStack(FragmentAa::class.java.simpleName)
                .commit()
        }
    }

}