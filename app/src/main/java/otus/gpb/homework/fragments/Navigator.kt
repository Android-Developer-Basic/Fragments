package otus.gpb.homework.fragments

import androidx.fragment.app.Fragment

interface Navigator {

    fun callNextFragment(fragment: Fragment)
}