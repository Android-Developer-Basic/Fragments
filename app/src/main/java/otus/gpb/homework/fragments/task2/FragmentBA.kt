package otus.gpb.homework.fragments.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import otus.gpb.homework.fragments.R

class FragmentBA : Fragment(){

    private var buttonGone = false
    private var color = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParam()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(color != 0 ) {
            setColor(color, view)
        }
        val resultListener = FragmentResultListener { requestKey, result ->
            color = result.getInt("keyFromBB")
            setColor(color, view)
        }

        // Слушаем результат от "ББ" с ключом "requestKeyFromBB"
        parentFragmentManager.setFragmentResultListener(
            "requestKeyFromBB",
            viewLifecycleOwner,
            resultListener
        )


        val openBB = view.findViewById<Button>(R.id.openBA)
        if(buttonGone){
            openBB.visibility = View.GONE
        }

        openBB.setOnClickListener {
            val fragmentBB = FragmentBB.newInstanceFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerLeft,fragmentBB)
                .addToBackStack("fragment_BA_Replace_Fragment_BB")
                .commit()
        }
    }

    private fun setColor(color: Int, view: View) {
        if(color != 0 ) {
            view.setBackgroundColor(color)
            parentFragmentManager.setFragmentResult("color_key", bundleOf("color" to color))
        }
    }

    private fun parseParam(){
        val args = requireArguments()
        if(!args.containsKey(KEY_GONE)){
            throw Exception("No param in fragment BA")
        }
        buttonGone = args.getBoolean(KEY_GONE)

        if(!args.containsKey(KEY_COLOR)){
            throw Exception("No param in fragment BA")
        }
        color = args.getInt(KEY_COLOR)
    }

    companion object{
        private val KEY_GONE = "key_gone"
        private val KEY_COLOR = "key_color"

        fun newInstance(buttonGone: Boolean, color: Int): FragmentBA{
            return FragmentBA().apply {
                arguments = Bundle().apply {
                    putBoolean(KEY_GONE, buttonGone)
                    putInt(KEY_COLOR, color)
                }
            }
        }
    }
}