package com.example.bakis.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExpViewModel : ViewModel() {
    private val mutquestion1 = MutableLiveData<String>("")
    val question1: LiveData<String> get () = mutquestion1

    fun setQ(q: String) {
        mutquestion1.value = q
    }

    fun getQ(): String {
        return mutquestion1.value.toString()
    }
}