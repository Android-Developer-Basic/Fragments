package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.FragmentBB.Companion.ARG_COLOR
import otus.gpb.homework.fragments.FragmentBB.Companion.VALUE

class FragmentBA : Fragment(R.layout.fragment_ba) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button?>(R.id.show_fragmentbb)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerB, FragmentBB())
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener(VALUE, this) { _, result ->
            val color = result.getInt(ARG_COLOR)
            view.setBackgroundColor(color)
        }

    }
}
