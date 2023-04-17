package otus.gpb.homework.fragments

import android.widget.Button
import android.widget.TextView

class TextChanger(textView:TextView? = null,
                  button: Button? = null,
                  tVText:String? = null,
                  btnText:String? = null) {
    init {
        textView?.let { it.text = tVText }
        button?.let { it.text = "Open $btnText" }
    }
}