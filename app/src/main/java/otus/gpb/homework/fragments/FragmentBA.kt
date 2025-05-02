package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class FragmentBA: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyColor {
            c->view.setBackgroundColor(c)
        }

        val openBB = view.findViewById<Button>(R.id.open_fragment_bb)
        openBB?.isVisible =
            resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE

        openBB.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_b_container, FragmentBB())
                .commit()
        }
    }
}