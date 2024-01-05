package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA: Fragment(R.layout.fragment_ba) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonOpenFragmentBB = view.findViewById<Button>(R.id.open_fragment_bb)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            buttonOpenFragmentBB.visibility = View.GONE
        } else {
            buttonOpenFragmentBB.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_container, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }

        parentFragmentManager.setFragmentResultListener("value", this) { _, result ->
            val color = result.getInt("color")
            view.setBackgroundColor(color)
        }
    }
}