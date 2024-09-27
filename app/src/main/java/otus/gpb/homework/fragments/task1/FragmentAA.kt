package otus.gpb.homework.fragments.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentAA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_layout,
            container,
            false
        )

        view.findViewById<Button>(R.id.frag_open_button).apply {
            text = context.getString(R.string.open_frag_button, FragmentAB.TAG)

            setOnClickListener {

                parentFragmentManager.beginTransaction()
                    .add(
                        R.id.frag_container,
                        FragmentAB.getInstance(ColorGenerator.generateColor())
                    )
                    .addToBackStack(FragmentAB.TAG)
                    .commit()

            }
        }

        view.findViewById<TextView>(R.id.frag_title).apply {
            text = context.getString(R.string.frag_name, TAG)
        }

        val receivedColor = requireArguments().getInt(ARG_COLOR, 0)
        view.setBackgroundColor(receivedColor)

        return view
    }


    companion object {
        const val TAG = "Fragment_AA"
        private const val ARG_COLOR = "color"

        fun getInstance(color: Int): FragmentAA {
            val frag = FragmentAA()
            val args = Bundle()
            args.putInt(ARG_COLOR, color)
            frag.arguments = args

            return frag
        }
    }
}