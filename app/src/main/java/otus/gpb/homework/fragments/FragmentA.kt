package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import otus.gpb.homework.fragments.databinding.FragmentActivityBinding

class FragmentA:Fragment() {
    private val fragmentDataModel: FragmentsDataVM by activityViewModels()
    private lateinit var binding: FragmentActivityBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val onBackClick = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(childFragmentManager.backStackEntryCount > 0){
                    childFragmentManager.popBackStack()

                }
                else{
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackClick)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityBinding.inflate(inflater)
        changeText()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDataModel.data.observe(activity as LifecycleOwner) {
            when (it) {
                SWIPED -> binding.root.apply {
                    left = width
                    setBackgroundColor(ColorGenerator.generateColor())
                    val looper:Looper = Looper.myLooper()!!
                    Handler(looper).postDelayed({
                        SwipeView(
                            this,
                            500,
                            AccelerateInterpolator()
                        ).unWrap(width, 0)
                    },1)
                }


                OPEN_FRAGMENT_AB ->{
                    childFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragmentLayout, FragmentAB())
                        .commit()
                }

            }
        }
        binding.fragmentButton.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentLayout, FragmentAA())
                .commit()
        }
    }

    private fun changeText(){
        TextChanger(binding.fragmentText, binding.fragmentButton, resources.getString(R.string.fragmentA), resources.getString(R.string.fragmentAA))
    }
}