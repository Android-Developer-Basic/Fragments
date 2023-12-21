package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import otus.gpb.homework.fragments.databinding.FragmentABinding

class FragmentA : Fragment(R.layout.fragment_a) {

    private lateinit var binding: FragmentABinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()

                    binding.buttonOpenFragmentAA.visibility = if (childFragmentManager.backStackEntryCount <= 1) View.VISIBLE else View.INVISIBLE
                } else {
                    isEnabled = false
                    activity?.finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentABinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)

        binding.buttonOpenFragmentAA.setOnClickListener {
            binding.fragmentContainerA.visibility = View.VISIBLE

            val fragmentAA = FragmentAA.newInstance(ColorGenerator.generateColor())
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_a, fragmentAA)
                .addToBackStack(null)
                .commit()

            binding.buttonOpenFragmentAA.visibility = View.INVISIBLE
        }

        return binding.root
    }
}