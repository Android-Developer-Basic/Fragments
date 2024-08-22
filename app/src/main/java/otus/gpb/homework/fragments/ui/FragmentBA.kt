package otus.gpb.homework.fragments.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.FragmentBActivity
import otus.gpb.homework.fragments.R


class FragmentBA : Fragment(R.layout.fragment_b_a) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().supportFragmentManager.setFragmentResultListener(
            FragmentBActivity.KEY_REQUEST,
            this
        ) { _, bundle ->
            val result = bundle.getInt(FragmentBActivity.KEY_COLOR)
            view.setBackgroundColor(result)
        }

        val orientation = resources.configuration.orientation
        val button = view.findViewById<Button>(R.id.buttonOpenFragmentBB)
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            button.visibility = View.VISIBLE
            button.text = "FragmentBB"
            button.setOnClickListener() {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_fragment_b, FragmentBB()).addToBackStack(null).commit()
            }
        } else {
            button.visibility = View.GONE
        }
    }
}