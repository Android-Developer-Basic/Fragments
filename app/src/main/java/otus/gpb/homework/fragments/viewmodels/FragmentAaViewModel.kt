package otus.gpb.homework.fragments.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentAaViewModel : ViewModel() {

    private val colorValue = MutableLiveData<Int>()
    val color: LiveData<Int>
        get() = colorValue

    fun setColor(value: Int) {
        colorValue.value = value
    }

}