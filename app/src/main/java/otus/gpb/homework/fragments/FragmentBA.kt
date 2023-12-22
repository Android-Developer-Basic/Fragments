package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentBABinding
import otus.gpb.homework.fragments.databinding.FragmentTasksBinding

interface UpdateLayout{
    fun updateBackgroundColor(color: Int)
}

class FragmentBA : Fragment(R.layout.fragment_b_a), UpdateLayout {

    private lateinit var binding: FragmentBABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentBABinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBABinding.inflate(inflater, container, false)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            binding.buttonOpenFragmentBB.setOnClickListener {
                val fragmentBB = FragmentBB()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerViewTask2, fragmentBB)
                    .addToBackStack(null)
                    .commit()
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        buttonOpenFragmentVisible()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(
            ColorGenerator.ARG_COLOR_REQUEST,
            this
        ) { _, result ->
            val color = result.getInt(ColorGenerator.ARG_COLOR, Color.WHITE)
            updateBackgroundColor(color)
        }
    }

    private fun buttonOpenFragmentVisible(){
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            binding.buttonOpenFragmentBB.visibility = View.GONE
        else
            binding.buttonOpenFragmentBB.visibility = View.VISIBLE
    }

    override fun updateBackgroundColor(color: Int) {
        Log.d("Test", "updateBackgroundColor $color")
        binding.frameLayoutFragmentBA.setBackgroundColor(color)
    }
}