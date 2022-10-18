package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.databinding.FragmentBbBinding

class BBFragment : Fragment() {
    private lateinit var binding: FragmentBbBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBbBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendColorButton.setOnClickListener {
            setFragmentResult("requestKey", Bundle().apply {
                putInt("color", ColorGenerator.generateColor())
            })
        }
    }

    companion object {
        fun newInstance(): BBFragment {
            return BBFragment()
        }
    }

}