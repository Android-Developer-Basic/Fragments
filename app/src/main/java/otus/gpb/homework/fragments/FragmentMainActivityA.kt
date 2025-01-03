package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button

class FragmentMainActivityA : Fragment(R.layout.fragment_main_activity_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val button = view.findViewById<Button>(R.id.buttonOpenFragmentA)
            button.setOnClickListener(){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.containerActivityA, FragmentA())
                    .addToBackStack("")
                    .commit()
        }
    }
}