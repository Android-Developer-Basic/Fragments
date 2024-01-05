package otus.gpb.homework.fragments.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R


class FragmentAB : Fragment(){

    private var colorBackground: Int = UNKNOWN_COLOR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParam()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.setBackgroundColor(colorBackground)
    }

    private fun parseParam(){
        val args = requireArguments()
        if(!args.containsKey(COLOR_BACKGROUND_KEY)){
            throw Exception("Don't color")
        }
        colorBackground = args.getInt(COLOR_BACKGROUND_KEY)
    }
    

    companion object{
        private val UNKNOWN_COLOR = 0
        private val COLOR_BACKGROUND_KEY = "colorBackground"
        fun fragmentABInstance(colorBackground: Int): FragmentAB {
            return FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_BACKGROUND_KEY, colorBackground)
                }
            }
        }
    }
}