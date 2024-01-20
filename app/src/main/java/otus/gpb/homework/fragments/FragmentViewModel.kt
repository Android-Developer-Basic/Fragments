package otus.gpb.homework.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {

    private var aa_color = MutableLiveData<Int>()
    val fragmentAAcolor: LiveData<Int> = aa_color

    private var ab_color = MutableLiveData<Int>()
    var fragmentABcolor = ab_color

    fun setFragmentAAcolor(value: Int) {
        aa_color.value = value
    }

    fun setFragmentABcolor(value: Int) {
        ab_color.value = value
    }
}