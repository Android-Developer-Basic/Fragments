package otus.gpb.homework.fragments.usecaseB

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.usecaseB.FragmentBB

class FragmentBA : Fragment(R.layout.fragment_ba) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("app", "fragment_ba on view")

        view.findViewById<AppCompatButton>(R.id.button_open_fragment_bb)?.apply {
            setOnClickListener {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_ba_main_frame, FragmentBB())
                    .addToBackStack(null)
                    .commit()
                Log.d("app", "clicked button to open fragment_bb")
            }
        }

        setFragmentResultListener("key") { _, bundle ->
            val color = bundle.getInt("color")

            view.findViewById<ConstraintLayout>(R.id.fragment_ba_main_frame)?.background = color.toDrawable()

            Toast.makeText(
                this@FragmentBA.context,
                "FragmentBA received color #$color",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val index = childFragmentManager.backStackEntryCount
                if (index > 0) {
                    childFragmentManager.popBackStack()
                }
                else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
}