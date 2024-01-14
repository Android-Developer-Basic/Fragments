package otus.gpb.homework.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {

    private var color = MutableLiveData<Int>()
    val colorValue: LiveData<Int> = color

    fun setColor(value: Int) {
        color.value = value
    }
}