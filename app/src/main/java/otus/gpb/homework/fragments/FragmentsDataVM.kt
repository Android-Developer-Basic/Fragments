package otus.gpb.homework.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentsDataVM: ViewModel() {
    val data: MutableLiveData<Any> by lazy {
        MutableLiveData<Any>()
    }


}