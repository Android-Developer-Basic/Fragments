package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class FragmentBB : Fragment(R.layout.fragment_bb) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonSendColor).setOnClickListener {
            val color = ColorGenerator.generateColor()
            // Тот же requestKey, что слушает FragmentBA на этом FragmentManager.
            setFragmentResult(
                FragmentBA.REQUEST_KEY,
                bundleOf(FragmentBA.KEY_COLOR to color)
            )
            // В portrait BB лежит поверх BA в back stack — возвращаемся, чтобы увидеть цвет.
            if (parentFragmentManager.backStackEntryCount > 0) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}
