package otus.gpb.homework.fragments.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.SecondActivity

class FragmentA : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_a, container, false)
        v.findViewById<Button>(R.id.goToFragmentAA).setOnClickListener {
            val color = ColorGenerator.generateColor()
            val fAA = FragmentAA.newInstance(color)
            parentFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragmentContainer, fAA).commit()
        }
        v.findViewById<Button>(R.id.goToSecondActivity).setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            startActivity(intent)
        }
        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentA()
    }
}