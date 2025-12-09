package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentBA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeResult { color ->
            view.setBackgroundColor(color)
        }

        val orientation = requireActivity().resources.configuration.orientation

        val btnFragmentBb = view.findViewById<Button>(R.id.btn_open_fragmentBB)

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btnFragmentBb.visibility = View.GONE
        } else {
            btnFragmentBb.visibility = View.VISIBLE

            btnFragmentBb.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment_ba, FragmentBB())
                    .setReorderingAllowed(true)
                    .addToBackStack("")
                    .commit()
            }
        }
    }
}