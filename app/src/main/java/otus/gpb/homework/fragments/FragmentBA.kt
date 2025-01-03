package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.fragment.app.setFragmentResult
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener

class FragmentBA : Fragment(R.layout.fragment_ba) {

    private var color: Int = 0
    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById<Button>(R.id.buttonOpenFragmentBB)
        button.setOnClickListener() {
            setFragmentResult("toFragmentBB", bundleOf("color" to color))
            val fm = parentFragmentManager.beginTransaction()
            if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                fm.hide((requireActivity() as ActivityB).getFragmentBA())
            }
            fm.show((requireActivity() as ActivityB).getFragmentBB())
            fm.commit()
        }
        setColorOfButton()
        setFragmentResultListener("toFragmentBA") { _, bundle ->
            val color = bundle.getInt("color")
            getView()?.setBackgroundColor(color)
            setColorOfButton()
        }
    }

    private fun setColorOfButton(){
        color = ColorGenerator.generateColor()
        button.setBackgroundColor(color)
    }
}