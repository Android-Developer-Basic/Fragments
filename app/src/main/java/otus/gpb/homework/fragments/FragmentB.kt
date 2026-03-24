package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba, FragmentBA())
                .replace(R.id.fragment_bb, FragmentBB())
                .addToBackStack(null)
                .commit()
            return inflater.inflate(R.layout.activity_b_land, container, false)
        } else {
            childFragmentManager.beginTransaction()
                .replace(R.id.activity_b, FragmentBA())
                .addToBackStack(null)
                .commit()
            return inflater.inflate(R.layout.activity_b, container, false)
        }
    }
}