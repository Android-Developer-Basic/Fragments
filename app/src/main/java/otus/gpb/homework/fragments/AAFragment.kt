package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback

private const val COLOR_ID = "colorId"

class AAFragment : Fragment() {
    private var colorId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            colorId = it.getInt(COLOR_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.call_fragment_ab).setOnClickListener {
            (requireActivity() as Navigator).callNextFragment(ABFragment.newInstance(ColorGenerator.generateColor()))
        }
        colorId.let {
            view.setBackgroundColor(colorId!!)
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val host = requireActivity()

                if (host.supportFragmentManager.backStackEntryCount == 1) {
                    host.finish()
                } else {
                    host.supportFragmentManager.popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(colorId: Int) =
            AAFragment().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_ID, colorId)
                }
            }
    }
}