package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController

class FragmentBb : Fragment() {

    private var newColor : Int = ColorGenerator.generateColor()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bb, container, false)

        val btnSC = root.findViewById<Button>(R.id.button_send_color)
        btnSC.text = "SendColor - "+java.lang.Integer.toHexString(newColor)
        btnSC.setOnClickListener {
            requireActivity().supportFragmentManager
                .setFragmentResult(FragmentBa.FRAGMENT_KEY, Bundle().apply {
                putInt(FragmentBa.VALUE_KEY, newColor)

            })

            findNavController().navigateUp()
            newColor = ColorGenerator.generateColor()
            btnSC.text = "SendColor - "+java.lang.Integer.toHexString(newColor)

        }
        return root
    }


}