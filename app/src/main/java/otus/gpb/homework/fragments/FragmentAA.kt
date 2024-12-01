package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_aa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            try {
                view.setBackgroundColor(requireArguments().getInt("color"))
            } catch (e: IllegalStateException) {
                Toast.makeText(this.context, "Fragment AA: No arguments passed", Toast.LENGTH_SHORT)
                    .show()
            }

            view.findViewById<Button>(R.id.button_open_frgAB).apply {
                setOnClickListener {
                    val key = "FragmentAB"
                    parentFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_AB,
                            FragmentAB::class.java,
                            bundleOf("color" to ColorGenerator.generateColor()),
                            key
                        )
                        .addToBackStack(key)
                        .commit()
                }
            }
        }
    }

}
