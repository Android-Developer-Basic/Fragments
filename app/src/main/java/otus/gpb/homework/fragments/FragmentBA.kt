package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Слушаем результат на parentFragmentManager — тот же менеджер, куда BB кладёт цвет.
        setFragmentResultListener(REQUEST_KEY) { _, bundle ->
            view.setBackgroundColor(bundle.getInt(KEY_COLOR))
        }

        val openButton = view.findViewById<Button>(R.id.buttonOpenFragmentBB)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // В landscape BB уже на экране рядом — кнопка открытия не нужна.
            openButton.visibility = View.GONE
        } else {
            openButton.setOnClickListener {
                // parentFragmentManager = childFragmentManager FragmentB → BA и BB соседи.
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.container_ba, FragmentBB())
                    addToBackStack(null)
                }
            }
        }
    }

    companion object {
        const val REQUEST_KEY = "color_request"
        const val KEY_COLOR = "color"
    }
}
