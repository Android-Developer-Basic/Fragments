package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentBaBinding

class BAFragment : Fragment() {
    private lateinit var binding: FragmentBaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentBbButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.start_container, BBFragment.newInstance()).addToBackStack("null")
                .setReorderingAllowed(true).commit()
        }
        parentFragmentManager.setFragmentResultListener("requestKey", this) { requestKey, result ->
            val color = result.getInt("color")
            binding.layout.setBackgroundColor(color)
        }

    }

    companion object {
        fun newInstance(): BAFragment {
            return BAFragment()
        }
    }

}