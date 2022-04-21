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

    val wasFabPressed = MutableLiveData(false)

    fun getAnswers(): MutableList<Answer>? {
        return answerList.value
    }

    fun setAnswers(answer: Answer) {

        val list = mutableListOf(answer)

        if (answerList.value != null) {
            val temp = answerList.value!!
            temp.addAll(list)
            answerList.value = temp
        } else {
            answerList.value = list
        }
        val tempval = currentQuestion.value
        currentQuestion.value = tempval?.plus(1)
    }

    fun getcurrentQuestion(): Int? {
        return currentQuestion.value?.toInt()
    }

    fun setCurrentQuestion(qNum: Int) {
        currentQuestion.value = qNum
    }

    fun getQuestion(type: Boolean): Int {

        var tempNum = 0
        val currQuest = getcurrentQuestion()

        //category
        if (type) {
            when (currQuest) {
                1, 2, 3, 4, 5, 6 -> tempNum = R.string.e_cat
                7, 8, 9 -> tempNum = R.string.n_cat
                10 -> tempNum = R.string.h_cat
            }
        }

        //specific
        if (!type) {
            when (currQuest) {
                1 -> tempNum = R.string.e1_q
                2 -> tempNum = R.string.e2_q
                3 -> tempNum = R.string.e3_q
                4 -> tempNum = R.string.e4_q
                5 -> tempNum = R.string.e5_q
                6 -> tempNum = R.string.e6_q
                7 -> tempNum = R.string.n1_q
                8, 9 -> tempNum = R.string.n2_n3_q
                10 -> tempNum = R.string.h_q
            }
        }

        return tempNum
    }

    fun getAnswer(type: Boolean, number: Int): Int {

        val currQuest = getcurrentQuestion()
        var tempNum = 0

        when (currQuest) {
            1, 2, 3, 4, 5, 6 -> tempNum = getElemAnswer(type, number)
            7, 8, 9 -> tempNum = getNavAnswer(type, number)
            10 -> tempNum = getHapAnswer(type, number)
        }

        return tempNum
    }

    fun getElemAnswer(type: Boolean, num: Int): Int {

        var tempNum = 0
        val currQuest = getcurrentQuestion()

        //category
        if (type) {
            when (num) {
                1 -> tempNum = R.string.e1_cat
                2 -> tempNum = R.string.e2_cat
                3 -> tempNum = R.string.e3_cat
                4 -> tempNum = R.string.e4_cat
                5 -> tempNum = R.string.e5_cat
            }
        }

        //specific
        if (!type) {

            if (currQuest == 1) {
                when (num) {
                    1 -> tempNum = R.string.e1_a1
                    2 -> tempNum = R.string.e1_a2
                    3 -> tempNum = R.string.e1_a3
                    4 -> tempNum = R.string.e1_a4
                    5 -> tempNum = R.string.e1_a5
                }
            }

            if (currQuest == 2 || currQuest == 3) {
                when (num) {
                    1 -> tempNum = R.string.e2_e3_a1
                    2 -> tempNum = R.string.e2_e3_a2
                    3 -> tempNum = R.string.e2_e3_a3
                    4 -> tempNum = R.string.e2_e3_a4
                    5 -> tempNum = R.string.e2_e3_a5
                }
            }

            if (currQuest == 4 || currQuest == 5) {
                when (num) {
                    1 -> tempNum = R.string.e4_e5_a1
                    2 -> tempNum = R.string.e4_e5_a2
                    3 -> tempNum = R.string.e4_e5_a3
                    4 -> tempNum = R.string.e4_e5_a4
                    5 -> tempNum = R.string.e4_e5_a5
                }
            }

            if (currQuest == 6) {
                when (num) {
                    1 -> tempNum = R.string.e6_a1
                    2 -> tempNum = R.string.e6_a2
                    3 -> tempNum = R.string.e6_a3
                    4 -> tempNum = R.string.e6_a4
                    5 -> tempNum = R.string.e6_a5
                }
            }
        }

        return tempNum
    }

    fun getNavAnswer(type: Boolean, num: Int): Int {

        var tempNum = 0
        val currQuest = getcurrentQuestion()

        //category
        if (type) {
            when (num) {
                1 -> tempNum = R.string.n1_h1_cat
                2 -> tempNum = R.string.n2_h2_cat
                3 -> tempNum = R.string.n3_h3_cat
                4 -> tempNum = R.string.n4_h4_cat
                5 -> tempNum = R.string.n5_h5_cat
            }
        }

        //specific
        if (!type) {
            if (currQuest == 7) {
                when (num) {
                    1 -> tempNum = R.string.n1_a1
                    2 -> tempNum = R.string.n1_a2
                    3 -> tempNum = R.string.n1_a3
                    4 -> tempNum = R.string.n1_a4
                    5 -> tempNum = R.string.n1_a5
                }
            }

            if (currQuest == 8 || currQuest == 9) {
                when (num) {
                    1 -> tempNum = R.string.n2_n3_a1
                    2 -> tempNum = R.string.n2_n3_a2
                    3 -> tempNum = R.string.n2_n3_a3
                    4 -> tempNum = R.string.n2_n3_a4
                    5 -> tempNum = R.string.n2_n3_a5
                }
            }
        }

        return tempNum
    }

    fun getHapAnswer(type: Boolean, num: Int): Int {

        var tempNum = 0

        //category
        if (type) {
            when (num) {
                1 -> tempNum = R.string.n1_h1_cat
                2 -> tempNum = R.string.n2_h2_cat
                3 -> tempNum = R.string.n3_h3_cat
                4 -> tempNum = R.string.n4_h4_cat
                5 -> tempNum = R.string.n5_h5_cat
            }
        }

        //specific
        if (!type) {
            when (num) {
                1 -> tempNum = R.string.h_a1
                2 -> tempNum = R.string.h_a2
                3 -> tempNum = R.string.h_a3
                4 -> tempNum = R.string.h_a4
                5 -> tempNum = R.string.h_a5
            }
        }

        return tempNum
    }
}
