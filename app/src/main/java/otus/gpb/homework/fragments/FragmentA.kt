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
                            backStackEntryCount == 1 -> binding.buttonFragmentAA.isEnabled = true//при нажатии на точку, где находится кнопка в A, прыгаем в новый АА
                            else -> {
                                isEnabled = false
                                (host as MainActivity).onBackPressedDispatcher.onBackPressed()
                            }
                        }
                    }
                }
            }
        )

        arguments?.getInt("Color")?.let { color ->
            view.setBackgroundColor(color)
        }

        binding.apply {
            buttonFragmentAA.setOnClickListener { button ->
                button.isEnabled = false
                childFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container_a, FragmentAA().apply {
                        arguments = Bundle().apply { putInt("Color", ColorGenerator.generateColor()) }
                    })
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }
}