package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class Fragment_A : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.OpenFragment_AA).setOnClickListener{
            val Fr_AA = Fragment_AA()
            parentFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout_AA, Fr_AA, "Fr_AA")
                .addToBackStack(null)
                .commit()
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    if(parentFragmentManager.fragments.count() > 1 )
                        parentFragmentManager.popBackStack()
                    else
                        requireActivity().finish()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

}