import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.FragmentBB
import otus.gpb.homework.fragments.R

class FragmentBA : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_ba, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view.findViewById<View>(R.id.button_open_fragment_bb).visibility = View.GONE
        } else {
            view.findViewById<View>(R.id.button_open_fragment_bb).visibility = View.VISIBLE
            view.findViewById<View>(R.id.button_open_fragment_bb).setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }

        // Прослушиваем результаты от FragmentBB
        parentFragmentManager.setFragmentResultListener(
            "colorRequestKey",
            viewLifecycleOwner
        ) { requestKey, result ->
            if (requestKey == "colorRequestKey") {
                val color = result.getInt("color", Color.WHITE)
                updateBackgroundColor(color)
            }
        }
    }

    fun updateBackgroundColor(color: Int) {
        rootView.setBackgroundColor(color)
    }
}
