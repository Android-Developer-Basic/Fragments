package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragment_AA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.view?.setBackgroundColor(ColorGenerator.generateColor())
        view.findViewById<Button>(R.id.OpenFragment_AB).setOnClickListener{
            val Fr_AB = Fragment_AB()
            parentFragmentManager.
            beginTransaction()
                .replace(R.id.FrameLayout_AA, Fr_AB, "Fr_AB")
                .addToBackStack(null)
                .commit()
        }
    }
}