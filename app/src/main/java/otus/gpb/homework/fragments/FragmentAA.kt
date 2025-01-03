package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

class FragmentAA : Fragment(R.layout.fragment_aa) {

    private var color: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if( savedInstanceState != null ) {
            color = savedInstanceState.getInt("color")
        } else {
            color = getArguments()?.getInt("toFragmentAA")
        }
        color?.let{ view.setBackgroundColor(it) }

       val button = view.findViewById<Button>(R.id.buttonOpenFragmentAB)
       button.setOnClickListener(){
           val bundle = Bundle()
           bundle.putInt("colorToFragmentAB", ColorGenerator.generateColor())
           val fragment = FragmentAB()
           fragment.setArguments(bundle)
           parentFragmentManager.beginTransaction()
               .replace(R.id.containerActivityA, fragment)
               .addToBackStack("")
               .commit()
       }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        color?.let{ outState.putInt("color", it) }
    }
}