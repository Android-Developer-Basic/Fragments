package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback

open class FragmentA : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true){

            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount >0 ) {
                    childFragmentManager.popBackStack()
                }
                else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }

        }

        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.text_a).setTextColor(ColorGenerator.generateColor())
        view.findViewById<Button>(R.id.btn_openAA).setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.frameforAA,FragmentAA())
                .addToBackStack("")
                .commit()
        }
    }
}