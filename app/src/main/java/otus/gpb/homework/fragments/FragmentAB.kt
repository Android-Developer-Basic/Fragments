package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentActivityBinding

class FragmentAB: Fragment() {
    private lateinit var binding: FragmentActivityBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityBinding.inflate(inflater)
        binding.fragmentLayout.setBackgroundColor(ColorGenerator.generateColor())
        TextChanger(textView = binding.fragmentText, tVText = resources.getString(R.string.fragmentAB))
        binding.fragmentButton.alpha = 0f
        return binding.root
    }


}