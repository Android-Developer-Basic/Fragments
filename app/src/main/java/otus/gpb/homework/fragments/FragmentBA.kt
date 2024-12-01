package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class FragmentBA : Fragment(R.layout.fragment_b_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            view.findViewById<Button>(R.id.open_b_b).setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.b_b_container, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }

        parentFragmentManager.setFragmentResultListener("color", this) { _, result ->
            val color = result.getInt("gotColor")
            view.setBackgroundColor(color)
        }
    }
}