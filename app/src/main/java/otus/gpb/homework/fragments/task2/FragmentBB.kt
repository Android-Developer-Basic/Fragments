package otus.gpb.homework.fragments.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentBB : Fragment() {

    private var placeOpen = UNKNOWN_PLACE_OPEN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParam()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val sendColor = view.findViewById<Button>(R.id.sendColor)

        sendColor.setOnClickListener {
            val newColor = ColorGenerator.generateColor()
            // Отправляем результат обратно в "БА"
            parentFragmentManager.setFragmentResult(
                "requestKeyFromBB",
                bundleOf("keyFromBB" to newColor)
            )

            //закрываем текущий фрагмент и возвращаемся в "БА
            if(placeOpen == FRAGMENT){
                parentFragmentManager.popBackStack()
            }
        }

    }

    private fun parseParam(){
        val args = requireArguments()
        if(!args.containsKey(PLACE_KEY)){
            throw Exception("No param FragmentBB")
        }
        placeOpen = args.getString(PLACE_KEY) ?: UNKNOWN_PLACE_OPEN
    }

    companion object {
        private val UNKNOWN_PLACE_OPEN =""

        private val PLACE_KEY = "PLACE_KEY"

        private val FRAGMENT = "Fragment"

        private val ACTIVITY = "Activity"
        fun newInstanceFragment(): FragmentBB {
            return FragmentBB().apply {
                arguments = Bundle().apply {
                    putString(PLACE_KEY, FRAGMENT)
                }
            }
        }
        fun newInstanceActivity(): FragmentBB {
            return FragmentBB().apply {
                arguments = Bundle().apply {
                    putString(PLACE_KEY, ACTIVITY)
                }
            }
        }
    }


}