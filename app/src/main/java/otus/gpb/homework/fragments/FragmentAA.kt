package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentAA : Fragment() {

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
        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val random_color = ColorGenerator.generateColor()
        view.setBackgroundColor(random_color)
        view.findViewById<Button>(R.id.btn_openAB).setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.frameforAB,FragmentAB())
                .addToBackStack("")
                .commit()
//            view.findViewById<Button>(R.id.btn_openAB).isVisible = false
        }
    }
}