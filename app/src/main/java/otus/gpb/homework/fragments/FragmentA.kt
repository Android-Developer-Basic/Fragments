package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {

    private lateinit var btn_A : Button

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Тут будем отлавливать back press фрагмента А
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val cfm = childFragmentManager
                val count = cfm.backStackEntryCount
                if (count > 0) {
                    childFragmentManager.popBackStack()
                    if (cfm.fragments.last()?.tag.toString() == "fragmentAA") {
                        btn_A.visibility = View.VISIBLE
                    }
                } else {
                    // выходим в стартовый активити
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_A = view.findViewById<Button>(R.id.button_AA)
        btn_A.setOnClickListener {
            btn_A.visibility = View.INVISIBLE
            val genColor = ColorGenerator.generateColor()
            val frame = FragmentAA.create(genColor)

            childFragmentManager.beginTransaction()
                .add(R.id.fragment_a_container, frame, "fragmentAA" )
                .addToBackStack("AA_transaction")
                .commit()
        }
    }
}