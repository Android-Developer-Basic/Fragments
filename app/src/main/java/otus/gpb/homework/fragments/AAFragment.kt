package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentAaBinding

class AAFragment : Fragment() {

    private lateinit var binding: FragmentAaBinding
    private var color: Int = Color.WHITE


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAaBinding.inflate(inflater, container, false)
        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(COLOR_KEY, color)
        }
        binding.layout.setBackgroundColor(color)
        val color = arguments?.getInt(COLOR_KEY) ?: Color.WHITE
        binding.layout.setBackgroundColor(color)
        return binding.root

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COLOR_KEY, color)
        super.onSaveInstanceState(outState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentAbButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.daddys_container, ABFragment.newInstance(ColorGenerator.generateColor()))
                .addToBackStack("null").commit()
        }

    }

    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
        fun newInstance(color: Int) = AAFragment().apply {
            arguments = Bundle().apply {
                putInt(COLOR_KEY, color)
            }
        }
    }

}