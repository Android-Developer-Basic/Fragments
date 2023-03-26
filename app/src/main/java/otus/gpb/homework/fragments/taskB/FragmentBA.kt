package otus.gpb.homework.fragments.taskB

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import otus.gpb.homework.fragments.R


class FragmentBA : Fragment(R.layout.fragment_b_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.open_fragment_bb)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_b_portrait, FragmentBB())
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener("color_from_bb", this) {_ , result ->
            val color = result.getInt ("color")
            view.setBackgroundColor(color)
        }
    }
}