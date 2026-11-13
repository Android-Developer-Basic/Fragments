package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class FragmentB : Fragment(R.layout.fragment_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            val isLandscape =
                resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

            childFragmentManager.commit {
                setReorderingAllowed(true)
                // BA и BB — дети FragmentB, то есть на одном уровне иерархии.
                replace(R.id.container_ba, FragmentBA())
                if (isLandscape) {
                    replace(R.id.container_bb, FragmentBB())
                }
            }
        }
    }
}
