package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Task2Fragment : Fragment() {

    private lateinit var fragmentBA: FragmentBA
    private lateinit var fragmentBB: FragmentBB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentBA = FragmentBA()

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            fragmentBB = FragmentBB()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentLeftContainerViewTask2, fragmentBA)
                .replace(R.id.fragmentRightContainerViewTask2, fragmentBB)
                .addToBackStack(null)
                .commit()
        }
        else{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewTask2, fragmentBA)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task2, container, false)
    }
}