package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import otus.gpb.homework.fragments.databinding.ActivityTask1Binding
import otus.gpb.homework.fragments.databinding.FragmentABinding


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                    val currentFragment = childFragmentManager.findFragmentByTag("AA")
                    if (currentFragment != null && currentFragment.isVisible ) {
                        binding.btnOpenFragmentAA.visibility = View.VISIBLE
                    }
                } else {
                    isEnabled = false
                    activity?.onBackPressedDispatcher?.onBackPressed()
                }
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOpenFragmentAA.setOnClickListener {
            val backgroundColor = ColorGenerator.generateColor()
            childFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerA, FragmentAA.newInstance(backgroundColor), "AA")
                    .addToBackStack(null)
                    .commit()
            binding.btnOpenFragmentAA.visibility = View.GONE
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment FragmentA.
         */
        @JvmStatic
        fun newInstance(): FragmentA = FragmentA()
    }
}