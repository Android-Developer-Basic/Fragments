package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import otus.gpb.homework.fragments.databinding.FragmentActivityBinding

class FragmentAA: Fragment() {
    private val fragmentDataModel: FragmentsDataVM by activityViewModels()
    private lateinit var binding: FragmentActivityBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityBinding.inflate(inflater)
        binding.fragmentLayout.setBackgroundColor(ColorGenerator.generateColor())
        TextChanger(binding.fragmentText, binding.fragmentButton, resources.getString(R.string.fragmentAA), resources.getString(R.string.fragmentAB))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentButton.setOnClickListener {
            fragmentDataModel.data.value = OPEN_FRAGMENT_AB
        }

    }



}