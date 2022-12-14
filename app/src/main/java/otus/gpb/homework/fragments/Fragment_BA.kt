package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class Fragment_BA : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__b_a, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("Color") { key, bundle ->
            val color = bundle.getInt("COLOR")
            this.view?.setBackgroundColor(color)
        }
        if (this.view?.findViewById<Button>(R.id.OpenFragment_BB) != null)
        {
            view.findViewById<Button>(R.id.OpenFragment_BB).setOnClickListener{
                val Fr_BB = Fragment_BB()
                parentFragmentManager.
                beginTransaction()
                    .replace(R.id.Fr_Port, Fr_BB, "Fr_BB")
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}

