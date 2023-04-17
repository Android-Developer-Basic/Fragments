package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentActivityBinding

class FragmentBB: Fragment() {
    private lateinit var binding: FragmentActivityBinding
    private val color = ColorGenerator.generateColor()



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
            fragmentText.text = resources.getString(R.string.fragmentBB)
            fragmentButton.text = resources.getString(R.string.sendColor)
            fragmentButton.setOnClickListener {
                parentFragmentManager.setFragmentResult("color", bundleOf("result" to color))
            }
        }

    }

}