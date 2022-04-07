package com.example.bakis.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bakis.Answer

class ExpViewModel : ViewModel() {
//    private val mutquestion1 = MutableLiveData<String>("")
//    val question1: LiveData<String> get () = mutquestion1
//
//    fun setQ(q: String) {
//        mutquestion1.value = q
//    }
//
//    fun getQ(): String {
//        return mutquestion1.value.toString()
//    }

    private val answerList: MutableLiveData<MutableList<Answer>> by lazy {
        MutableLiveData<MutableList<Answer>>()
    }

    fun getAnswers(): MutableList<Answer>?{
        return answerList.value
    }

    fun setAnswers(list: MutableList<Answer>) {

        if (answerList.value != null) {
            val temp = answerList.value!!
            temp.addAll(list)
            answerList.value = temp
        }

        answerList.value = list
    }
}