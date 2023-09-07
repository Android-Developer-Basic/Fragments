package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentABinding

class AFragment : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false)
        binding.fragmentAaButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.daddys_container,
                    AAFragment.newInstance(ColorGenerator.generateColor())
                )
                .addToBackStack("null")
                .commit()
            binding.daddysContainer.visibility = View.VISIBLE

        }
        return binding.root
    }

    companion object {
        fun newInstance(): AFragment {
            return AFragment()
        }
    }

}