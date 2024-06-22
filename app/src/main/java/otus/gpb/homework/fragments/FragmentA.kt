package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragmenta, container, false)

        view.findViewById<Button>(R.id.ToFragmentAAbtn).setOnClickListener {
            val fragmentAA = FragmentAA()
            val bundle = Bundle()
            val color = ColorGenerator.generateColor() // Получение случайного цвета
            bundle.putInt("color", color)
            fragmentAA.arguments = bundle

            view.findViewById<View>(R.id.text2).visibility = View.GONE
            view.findViewById<View>(R.id.ToFragmentAAbtn).visibility = View.GONE

            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_a_container, fragmentAA)
                .addToBackStack(null)
                .commit()


        }


        return view
    }
}