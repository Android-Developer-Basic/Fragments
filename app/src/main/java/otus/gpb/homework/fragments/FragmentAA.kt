package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentAaBinding

class FragmentAA : Fragment() {
    val binding by lazy { FragmentAaBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt("Color")?.let { color ->
            view.setBackgroundColor(color)
        }

        binding.apply {
            buttonFragmentAB.setOnClickListener {
                val color = ColorGenerator.generateColor()

                parentFragmentManager.beginTransaction().apply {
                    replace((host as FragmentA).binding.fragmentContainer.id, FragmentAB().apply {
                        arguments = Bundle().apply {
                            putInt("Color", color)
                        }
                    })
                    addToBackStack(null)
                }.commit()
            }
        }
    }

}