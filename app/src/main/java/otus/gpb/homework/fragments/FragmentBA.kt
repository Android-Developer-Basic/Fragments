package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import java.util.Objects

class FragmentBA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ba, container, false)

        val openFragmentBbButton = view.findViewById<Button>(R.id.openFragmentBbButton)
        openFragmentBbButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.second_frame_ba_layout, FragmentBB())
                .addToBackStack(null)
                .commit()
        }

        openFragmentBbButton.visibility = when (isLandscapeOrientation()) {
            true -> View.GONE
            false -> View.VISIBLE
        }

        return view
    }

    private fun isLandscapeOrientation(): Boolean =
        Objects.equals(Configuration.ORIENTATION_LANDSCAPE, resources.configuration.orientation)
}
