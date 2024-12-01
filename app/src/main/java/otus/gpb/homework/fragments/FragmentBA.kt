package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmentBA : Fragment(R.layout.fragment_b_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonOpenFragmentBB = view.findViewById<Button>(R.id.open_fragment_bb)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            buttonOpenFragmentBB.visibility = View.GONE
        } else {
            buttonOpenFragmentBB.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }

        parentFragmentManager.setFragmentResultListener("value", viewLifecycleOwner) { _, result ->
            val color = result.getInt("color")
            view.setBackgroundColor(color)
        }
    }
}
