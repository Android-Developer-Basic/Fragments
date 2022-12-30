package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class BAFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(BBFragment.COLOR_ID_BUNDLE_KEY, viewLifecycleOwner) {
                _, bundle ->
            val colorId = bundle.getInt(BBFragment.COLOR_ID_VALUE, R.color.teal_200)
            view.setBackgroundColor(colorId.toInt())
        }

        view.findViewById<Button>(R.id.toFragmentBB)?.let {
            it.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, BBFragment())
                    .commit()
            }
        }
    }
}