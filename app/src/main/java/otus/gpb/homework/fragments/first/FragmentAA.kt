package otus.gpb.homework.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentAA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.view?.setBackgroundColor(ColorGenerator.generateColor())
        view.findViewById<Button>(R.id.b_open_fr_ab).setOnClickListener {
            val fragmentAB = FragmentAB()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentAB, "fragment_ab")
                .addToBackStack(null)
                .commit()
        }
    }
    
}