package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class FragmentBA : Fragment(R.layout.ba_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val containerId = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) R.id.containerBB else R.id.containerBA
        view.findViewById<Button>(R.id.buttonBB).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(containerId, FragmentBB())
                .commit()
        }

        setFragmentResultListener("key") { _, bundle ->
            val color = bundle.getInt("color")
            view.findViewById<ConstraintLayout>(R.id.frameforBABB)
                .setBackgroundColor(color)
        }
    }
}