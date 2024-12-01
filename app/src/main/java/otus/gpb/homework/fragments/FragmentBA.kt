package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.FragmentBB.Companion.KEY_COLOR
import otus.gpb.homework.fragments.FragmentBB.Companion.KEY_RESULT

class FragmentBA : Fragment(R.layout.fragment_b_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button?>(R.id.open_bb_button)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_b, FragmentBB())
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener(KEY_RESULT, this) { _, result ->
            val color = result.getInt(KEY_COLOR)
            view.setBackgroundColor(color)
        }


    }
}