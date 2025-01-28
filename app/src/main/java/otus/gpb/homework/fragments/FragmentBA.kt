package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import java.util.Objects

private val KEY_COLOR = "key_color"

class FragmentBA: Fragment() {

    private var color: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?, ): View? {
        val view = inflater.inflate(R.layout.fragment_ba, container, false)

        parentFragmentManager.setFragmentResultListener(KEY_COLOR, this) { _, bundle ->
            color = bundle.getInt(KEY_COLOR)
            view.setBackgroundColor(color)
        }

        val openFragBB = view.findViewById<Button>(R.id.buttonOpenFragmentBB)

        // в ландшафтном режиме кнопки "Открыть BB" не должно быть
        openFragBB.visibility = when (isLandscape()) {
            true -> View.GONE
            false -> View.VISIBLE
        }

        // в портретном режиме при нажатии на кнопку вместо BA открыть BB
        openFragBB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout_ba, FragmentBB())
                .addToBackStack(null)
                .commit()
        }



        return view
    }

    private fun isLandscape(): Boolean =
        Objects.equals(Configuration.ORIENTATION_LANDSCAPE, resources.configuration.orientation)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COLOR, color)
    }

}