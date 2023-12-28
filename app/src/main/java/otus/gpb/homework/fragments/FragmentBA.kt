package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

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
        if (this.resources.configuration.orientation == 2) {
            view.findViewById<Button>(R.id.btn_openBB).isVisible = false
        }
        view.findViewById<Button>(R.id.btn_openBB).setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.frameforBB,FragmentBB())
                .addToBackStack("")
                .commit()
        }
        parentFragmentManager.setFragmentResultListener("send color", this) {_, result ->
            val value = result.getInt("color")
            view.setBackgroundColor(value)
        }
    }
}