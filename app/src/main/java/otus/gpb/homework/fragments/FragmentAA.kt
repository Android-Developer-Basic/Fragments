package otus.gpb.homework.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import otus.gpb.homework.fragments.databinding.FragmentAaBinding

private const val COLOR = "COLOR"

class FragmentAA : Fragment(R.layout.fragment_aa) {

    private var fragmentAaBinding: FragmentAaBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAaBinding.bind(view)
        fragmentAaBinding = binding

        arguments?.let {
            binding.fragmentAa
                .setBackgroundColor(it.getInt(COLOR))
        }

        binding.openFragmentAb.setOnClickListener {

            val color = ColorGenerator.generateColor()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_aa_container, FragmentAB.newInstance(color))
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onDestroyView() {
        fragmentAaBinding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(COLOR, color)
                }
            }
    }
}