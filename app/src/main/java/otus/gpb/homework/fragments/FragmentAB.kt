package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentActivityBinding

class FragmentAB(context: Context): Fragment() {
    private lateinit var binding: FragmentActivityBinding
    private val color = ColorGenerator.generateColor()
    private val fragmentName = context.resources.getString(R.string.fragmentAB)



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityBinding.inflate(inflater)
        binding.apply {
            fragmentLayout.setBackgroundColor(color)
            TextChanger(
                textView = binding.fragmentText,
                tVText = fragmentName
            )
            fragmentButton.alpha = 0f
            return root
        }
    }


}