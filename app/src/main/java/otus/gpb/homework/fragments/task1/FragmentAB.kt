package otus.gpb.homework.fragments.task1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R

class FragmentAB : Fragment(R.layout.fragment_layout) {

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(
//            R.layout.fragment_layout,
//            container,
//            false)
//
//        view.findViewById<Button>(R.id.frag_open_button).visibility = View.GONE
//
//        val receivedColor = requireArguments().getInt(ARG_COLOR, 0)
//        view.setBackgroundColor(receivedColor)
//
//        return view
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.frag_open_button).visibility = View.GONE

        view.findViewById<TextView>(R.id.frag_title).apply {
            text = context.getString(R.string.frag_name, TAG)
        }

        val receivedColor = requireArguments().getInt(ARG_COLOR, 0)
        view.setBackgroundColor(receivedColor)
    }

    companion object {
        const val TAG = "Fragment_AB"
        private const val ARG_COLOR = "color"

        fun getInstance(color: Int): FragmentAB {
            val frag = FragmentAB()
            val args = Bundle()
            args.putInt(ARG_COLOR, color)
            frag.arguments = args

            return frag
        }
    }
}