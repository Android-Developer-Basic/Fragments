package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentTasksBinding

class TasksFragment : Fragment(R.layout.fragment_tasks) {

    private lateinit var binding: FragmentTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTasksBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)

        binding.buttonOpenTask1.setOnClickListener {
            val fragmentA = FragmentA()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentA)
                .addToBackStack(null)
                .commit()
        }

        binding.buttonOpenTask2.setOnClickListener {
            val fragmentTask2 = Task2Fragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentTask2)
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

}