package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentBa : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(
            FragmentBa::class.java.simpleName,
            this
        ) { _, result -> view.setBackgroundColor(result.getInt(ARG_COLOR)) }
        view.findViewById<Button>(R.id.openFragmentBbButton)?.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerBbPortrait, FragmentBb(), FragmentBb::class.java.simpleName)
                .addToBackStack(FragmentBb::class.java.simpleName)
                .commit()
        }
    }

    companion object {
        const val ARG_COLOR = "color"
    }

}