package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import otus.gpb.homework.fragments.databinding.FragmentABinding
import otus.gpb.homework.fragments.databinding.FragmentBBinding



/**
 * A simple [Fragment] subclass.
 * Use the [FragmentB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentB : Fragment(), FragmentBA.ButtonFragmentOnClickListener {

    private var isLandScape = false
    private var fragmentBAColor: Int? = null

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isLandScape = resources.getBoolean(R.bool.isLandscape)
        fragmentBAColor = savedInstanceState?.getInt("fragmentBA_color")
        if (fragmentBAColor == null) {
            fragmentBAColor = ColorGenerator.generateColor()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        fragmentBAColor?.let {
            outState.putInt("fragmentBA_color", it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isLandScape) {
            val childFragment = FragmentBA.newInstance(fragmentBAColor!!)
            childFragmentManager.beginTransaction()
                .replace(R.id.container_ba, childFragment)
                .commit()

            view.postDelayed({ (childFragment as ButtonController).addButton(true) }, 500)


        } else {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_ba, FragmentBA.newInstance(fragmentBAColor!!))
                .replace(R.id.container_bb, FragmentBB.newInstance(ColorGenerator.generateColor()))
                .commit()
        }
    }


    override fun setButtonFragmentOnClickListener(button: Button) {
        val fragmentBB = FragmentBB.newInstance(ColorGenerator.generateColor())
        childFragmentManager.beginTransaction()
            .add(R.id.container_ba, fragmentBB)
            .addToBackStack(null)
            .commit()
    }

}

interface ButtonController {
    fun addButton(isActive: Boolean)
}