package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orientation = requireActivity().resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_fragment_ba, FragmentBA())
                .replace(R.id.container_fragment_bb, FragmentBB())
                .setReorderingAllowed(true)
                .commit()
        } else {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_fragment_ba, FragmentBA())
                .setReorderingAllowed(true)
                .commit()
        }
    }
}