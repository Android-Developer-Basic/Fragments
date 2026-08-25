package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentB : Fragment(R.layout.fragment_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isLandscape = isLandscape()

        if (isLandscape && childFragmentManager.backStackEntryCount > 0) {
            childFragmentManager.popBackStackImmediate(
                null,
                androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE,
            )
        }

        if (savedInstanceState == null) {
            val transaction = childFragmentManager.beginTransaction()
                .replace(R.id.fragment_b_primary_container, FragmentBA(), FRAGMENT_BA_TAG)

            if (isLandscape) {
                transaction.replace(
                    R.id.fragment_b_secondary_container,
                    FragmentBB.newInstance(closeAfterSending = false),
                    FRAGMENT_BB_LANDSCAPE_TAG,
                )
            }
            transaction.commit()
        } else {
            synchronizeLandscapeFragment(isLandscape)
        }
    }

    private fun synchronizeLandscapeFragment(isLandscape: Boolean) {
        val landscapeFragment = childFragmentManager
            .findFragmentByTag(FRAGMENT_BB_LANDSCAPE_TAG)

        when {
            isLandscape && landscapeFragment == null -> {
                childFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_b_secondary_container,
                        FragmentBB.newInstance(closeAfterSending = false),
                        FRAGMENT_BB_LANDSCAPE_TAG,
                    )
                    .commit()
            }

            !isLandscape && landscapeFragment != null -> {
                childFragmentManager.beginTransaction()
                    .remove(landscapeFragment)
                    .commit()
            }
        }
    }

    private fun isLandscape(): Boolean =
        resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    private companion object {
        const val FRAGMENT_BA_TAG = "fragment_ba"
        const val FRAGMENT_BB_LANDSCAPE_TAG = "fragment_bb_landscape"
    }
}