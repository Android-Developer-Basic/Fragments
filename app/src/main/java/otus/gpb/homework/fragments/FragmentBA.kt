package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import otus.gpb.homework.fragments.databinding.FragmentActivityBinding

class FragmentBA: Fragment() {
    private val fragmentDataModel: FragmentsDataVM by activityViewModels()
    private lateinit var binding: FragmentActivityBinding

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
            fragmentText.text = resources.getString(R.string.fragmentBA)
            fragmentButton.text = "Open " + resources.getString(R.string.fragmentBB)

        }

        fragmentDataModel.data.observe(activity as LifecycleOwner){
            when(it){
                HIDE_BUTTON -> {
                    binding.fragmentButton.apply {
                        setOnClickListener { }
                        alpha = 0f
                    }
                }

                SHOW_BUTTON -> {
                    binding.fragmentButton.apply {
                        setOnClickListener {
                        fragmentDataModel.data.value = OPEN_FRAGMENT_BB
                    }
                        alpha = 1.0f
                    }
                }
            }
        }

            parentFragmentManager.setFragmentResultListener("color", this){_, bundle ->
            val color = bundle.getInt("result")
            binding.root.setBackgroundColor(color)

        }
    }


}