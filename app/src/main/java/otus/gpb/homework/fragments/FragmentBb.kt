package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentBb : Fragment(R.layout.fragment_bb) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ColorGenerator.generateColor())
        view.findViewById<Button>(R.id.sendColorButton).setOnClickListener {
            parentFragmentManager.setFragmentResult(
                FragmentBa::class.java.simpleName,
                Bundle().apply { putInt(FragmentBa.ARG_COLOR, ColorGenerator.generateColor()) })
            parentFragmentManager.takeIf { it.backStackEntryCount > 0 }?.popBackStack()
        }
    }

}