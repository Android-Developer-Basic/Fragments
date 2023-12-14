package otus.gpb.homework.fragments


import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class FragmentBa : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_ba, container, false)

        val btnBB = root.findViewById<Button>(R.id.button_BB)
        btnBB.setOnClickListener {
                findNavController().navigate(R.id.action_to_fragment_bb)
            }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btnBB.visibility = View.INVISIBLE
        }

        // устанавливаем цвет полученный из fragmentBB
        requireActivity().supportFragmentManager
            .setFragmentResultListener(FRAGMENT_KEY, this) { _, bundle ->
            val newColor = bundle.getInt(VALUE_KEY)
            root.setBackgroundColor(newColor)
        }

        return root
    }

    companion object {
        const val FRAGMENT_KEY = "FragmentBA"
        const val VALUE_KEY = "colorKey"
    }
}