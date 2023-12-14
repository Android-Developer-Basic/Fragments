package otus.gpb.homework.fragments


import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment


class FragmentAA : Fragment(R.layout.fragment_aa) {

    private lateinit var btn_to_ab : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newColor = arguments?.getInt(ARG_VALUE)
        newColor?.let { view.setBackgroundColor(it) }

        btn_to_ab = requireActivity().findViewById<Button>(R.id.button_AB)
        btn_to_ab.setOnClickListener {
            btn_to_ab.visibility = View.INVISIBLE
            val genColor = ColorGenerator.generateColor()

            //requireParentFragment().childFragmentManager
              //.beginTransaction()
        //            childFragmentManager.beginTransaction()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_a_container, FragmentAB.create(genColor), "fragmentAB" )
                    .addToBackStack("=")
                    .commit()
        }
    }

    companion object {
        private const val ARG_VALUE = "value"
        fun create(value: Int): FragmentAA {
            val fragment = FragmentAA()
            val arguments = Bundle()
            arguments.putInt(ARG_VALUE, value)
            fragment.arguments = arguments
            return fragment
        }
    }
}