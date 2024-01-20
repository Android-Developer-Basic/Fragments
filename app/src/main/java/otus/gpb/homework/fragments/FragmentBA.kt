package otus.gpb.homework.fragments

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

        parentFragmentManager.setFragmentResultListener(
            REQUEST_KEY,
            this
        ) { _, result ->
            view.findViewById<View>(R.id.fragment_ba_layout).setBackgroundColor(result.getInt(COLOR))
        }

        view.findViewById<Button>(R.id.start_fragment_bb_btn)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba_container, FragmentBB())
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        const val COLOR = "color"
        const val REQUEST_KEY = "azaza"
    }
}