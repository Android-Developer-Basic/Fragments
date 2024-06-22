package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment() {

    private val color = ColorGenerator.generateColor() // Получение цвета из ColorGenerator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragmentaa, container, false)

        view.findViewById<Button>(R.id.buttonOpenFragmentAB).setOnClickListener {
            val fragmentAB = FragmentAB()
            val args = Bundle()
            args.putInt("color", color)
            fragmentAB.arguments = args

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_aa_container, fragmentAB)
                .addToBackStack(null)
                .commit()

            view.findViewById<View>(R.id.text3).visibility = View.GONE
            view.findViewById<View>(R.id.buttonOpenFragmentAB).visibility = View.GONE
        }

        return view


    }

}