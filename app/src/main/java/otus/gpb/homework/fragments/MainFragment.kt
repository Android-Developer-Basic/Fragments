package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainFragment: Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState:Bundle?){
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.openFragmentA).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentA())
                .commit()
            view.setBackgroundColor(ColorGenerator.generateColor())
        }
    }
}