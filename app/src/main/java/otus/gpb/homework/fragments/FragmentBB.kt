package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator.generateColor

class FragmentBB: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.send_color).setOnClickListener {
            if (resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_b_container, FragmentBA())
                    .commit()
            }
            sendColor(generateColor())
        }
    }
}