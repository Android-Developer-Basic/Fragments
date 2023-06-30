package otus.gpb.homework.fragments.usecaseA

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentA : Fragment(R.layout.fragment_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<AppCompatButton>(R.id.button_open_fragment_aa)

        Toast.makeText(this@FragmentA.context, "FragmentA", Toast.LENGTH_SHORT).show()

        button?.apply {
            setOnClickListener {
                childFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_frame_a, FragmentAA.create(ColorGenerator.generateColor()))
                    .addToBackStack("FragmentAA")
                    .commit()
                Log.d("app", "clicked button to open fragment_aa")
                // visibility = View.GONE
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val index = childFragmentManager.backStackEntryCount
                if (index > 0) {
                    /*val tag = childFragmentManager.getBackStackEntryAt(index)
                    if (tag.name.equals("FragmentAA")) {
                        view?.findViewById<AppCompatButton>(R.id.button_open_fragment_aa)?.visibility = View.VISIBLE
                    }*/
                    childFragmentManager.popBackStack()
                }
                else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
}