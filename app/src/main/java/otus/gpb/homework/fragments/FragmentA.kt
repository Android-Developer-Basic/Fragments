package otus.gpb.homework.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import otus.gpb.homework.fragments.databinding.FragmentLayoutBinding

class FragmentA:Fragment() {
    private val fragmentDataModel:FragmentsDataVM by activityViewModels()
    private lateinit var binding:FragmentLayoutBinding
    companion object{
        fun newInstance() = FragmentA()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDataModel.data.observe(activity as LifecycleOwner) {
            if (it == SWIPED) {
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.fragmentALayout.setBackgroundColor(ColorGenerator.generateColor())
                    SwipeView(
                        binding.fragmentALayout,
                        1000,
                        AccelerateInterpolator()
                    ).unWrap()
                }, 1)
            }

        }
    }
}