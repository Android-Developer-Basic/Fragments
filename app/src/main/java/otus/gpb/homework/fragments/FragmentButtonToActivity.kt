package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentButtonToActivity : Fragment() {

    private var whereStartFragment = UNKNOWN_FLAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParam()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_button,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.openFragmentButton)
        launchMode(button)

    }

    private fun setupListener(button: Button?, openFunction: () -> Unit) {
        button?.let {
            it.text = "Open fragment a"
            it.setOnClickListener {
                openFunction.invoke()
            }
        }
    }

    private fun openFragmentA() {
        val fragment = FragmentA.InstanceFragmentA()
        parentFragmentManager.beginTransaction()
            .addToBackStack("fragmentButtonReplaceToFragmentA")
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
    private fun openFragmentAA() {
        val fragment = FragmentAA.fragmentAAInstance(ColorGenerator.generateColor())
        parentFragmentManager.beginTransaction()
            .addToBackStack("fragmentButtonReplaceToFragmentAA")
            .replace(R.id.childContainer, fragment)
            .commit()
    }

    private fun launchMode(button: Button?){
        when(whereStartFragment){
            SETUP_ACTIVITY_FLAG -> setupListener(button) { openFragmentA() }
            SETUP_FRAGMENT_FLAG -> setupListener(button) { openFragmentAA() }
        }
    }

    private fun parseParam(){
        val args = requireArguments()
        if(!args.containsKey(KEY_FLAG)){
            throw Exception("UnknownStart")
        }
        whereStartFragment = args.getString(KEY_FLAG) ?: throw Exception("Empty param")
    }


    companion object {
        private val SETUP_FRAGMENT_FLAG = "SETUP_FRAGMENT_FLAG"
        private val SETUP_ACTIVITY_FLAG = "SETUP_ACTIVITY_FLAG"

        private val KEY_FLAG = "KEY_FLAG"

        private val UNKNOWN_FLAG = "UNKNOWN_FLAG"
        fun InctanceFromActivity(): FragmentButtonToActivity {
            return FragmentButtonToActivity().apply {
                arguments = Bundle().apply {
                    putString(KEY_FLAG, SETUP_ACTIVITY_FLAG)
                }
            }
        }

        fun InctanceFromFragment(): FragmentButtonToActivity {
            return FragmentButtonToActivity().apply {
                arguments = Bundle().apply {
                    putString(KEY_FLAG, SETUP_FRAGMENT_FLAG)
                }
            }
        }
    }
}