package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_open_fr_aa).setOnClickListener {
            val color = ColorGenerator.generateColor()
            childFragmentManager.beginTransaction()
                .replace(R.id.child_content_container,FragmentAA.newInstance(color))
                .addToBackStack(null)
                .commit()
        }
    }

   override fun onAttach(context: Context) {
       super.onAttach(context)
       val callback = object : OnBackPressedCallback(true) {
           override fun handleOnBackPressed() {
               if (childFragmentManager.backStackEntryCount > 0) {
                   childFragmentManager.popBackStack()
               } else {
                   isEnabled = false
                   activity?.onBackPressedDispatcher?.onBackPressed()
               }
           }
       }
       requireActivity().onBackPressedDispatcher.addCallback(this, callback)
   }
}