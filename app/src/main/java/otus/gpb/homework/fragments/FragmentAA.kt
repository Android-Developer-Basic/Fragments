package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf

class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id_color = arguments?.getInt("color")
        if (id_color != null) {
            view.setBackgroundColor(id_color)
        }

        val fragmentAB = FragmentAB()
        val button: Button = view.findViewById(R.id.buttonToFragmentAB)
        val bundle = Bundle()
        button.setOnClickListener() {
            bundle.putInt("color", ColorGenerator.generateColor())
            fragmentAB.arguments = bundle
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container_a, fragmentAB).addToBackStack(null).commit()
        }

    }
}
