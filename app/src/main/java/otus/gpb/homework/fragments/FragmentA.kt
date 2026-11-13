package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonOpenFragmentAA).setOnClickListener {
            // childFragmentManager управляет фрагментами, вложенными в FragmentA
            childFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.child_fragment_container,
                    FragmentAA.newInstance(ColorGenerator.generateColor())
                )
                addToBackStack(null)
            }
        }

        // Колбэк живёт, пока существует view фрагмента, и снимается автоматически.
        // Общий стек = FragmentA + дочерние записи. Пока есть дочерние (AA/AB) — снимаем по одному,
        // когда остался только сам FragmentA (размер стека = 1) — закрываем активити.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (childFragmentManager.backStackEntryCount > 0) {
                childFragmentManager.popBackStack()
            } else {
                requireActivity().finish()
            }
        }
    }
}
