package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import otus.gpb.homework.fragments.databinding.FragmentActivityBinding

class FragmentAA(context: Context): Fragment() {
    private val fragmentDataModel: FragmentsDataVM by activityViewModels()
    private lateinit var binding: FragmentActivityBinding
    private val color = ColorGenerator.generateColor()
    private val fragmentName = context.resources.getString(R.string.fragmentAA)
    private val nextFragmentName = context.resources.getString(R.string.fragmentAB)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            fragmentLayout.setBackgroundColor(color)
            TextChanger(
                fragmentText,
                fragmentButton,
                fragmentName,
                nextFragmentName
            )
            fragmentButton.setOnClickListener {
                fragmentDataModel.data.value = OPEN_FRAGMENT_AB
            }
        }

    }

}