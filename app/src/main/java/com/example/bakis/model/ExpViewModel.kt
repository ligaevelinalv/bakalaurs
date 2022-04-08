package com.example.bakis.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bakis.Answer
import com.example.bakis.R

class ExpViewModel : ViewModel() {

    private val currentQuestion = MutableLiveData(1)

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
        else{
            answerList.value = list
        }

        val tempval = currentQuestion.value
        currentQuestion.value = tempval?.plus(1)
    }

    fun getcurrentQuestion(): Int? {
        return currentQuestion.value?.toInt()
    }

    fun getCategoryQuestion(): Int {
        var tempNum = 0

        when (getcurrentQuestion()) {
            1, 2, 3, 4, 5, 6 -> tempNum = R.string.e_q1
            7, 8, 9 -> tempNum = R.string.n_q1
            10 -> tempNum = R.string.h_q1
        }

        return tempNum
    }

    fun getspecificQuestion(): Int {
        var tempNum = 0

        when (getcurrentQuestion()) {
            1 -> tempNum = R.string.e1_q2
            2 -> tempNum = R.string.e2_q2
            3 -> tempNum = R.string.e3_q2
            4 -> tempNum = R.string.e4_q2
            5 -> tempNum = R.string.e5_q2
            6 -> tempNum = R.string.e6_q2
            7 -> tempNum = R.string.n2_q2
            8, 9 -> tempNum = R.string.n2_n3_q2
            10 -> tempNum = R.string.h_q2
        }

        return tempNum
    }

}