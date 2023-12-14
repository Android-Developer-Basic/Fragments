package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment


class FragmentB: Fragment(R.layout.fragment_b) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // container
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // set controller
        val navController: NavController = navHostFragment.navController

        if (resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE) {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_bb_container, FragmentBb(), "tag_BB")
                .commit()
        }
    }
}