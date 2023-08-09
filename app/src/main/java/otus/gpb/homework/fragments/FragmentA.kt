package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {
    val binding by lazy { FragmentABinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    childFragmentManager.apply {
                        when {
                            backStackEntryCount > 0 -> popBackStackImmediate()
                            backStackEntryCount == 1 -> binding.buttonFragmentAA.visibility =
                                View.VISIBLE

                            else -> {
                                isEnabled = false
                                requireActivity().onBackPressedDispatcher.onBackPressed()
                            }
                        }
                    }
                }
            }
        )

        binding.apply {
            buttonFragmentAA.setOnClickListener { button ->
                button.visibility = View.INVISIBLE
                val color = ColorGenerator.generateColor()

                childFragmentManager.beginTransaction().apply {
                    replace(fragmentContainer.id, FragmentAA().apply {
                        arguments = Bundle().apply { putInt("Color", color) }
                    })
                    addToBackStack(null)
                }.commit()
            }
        }
    }
}