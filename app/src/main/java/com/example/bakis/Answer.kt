package com.example.bakis

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Answer (
    var solutionUsed: Boolean? = null,
    var categoryAnswer: Int = 0,
    var specificAnswer: Int = 0
){

@Exclude

fun toMap(): Map<String, Any?> {
    return mapOf(
        "solutionUsed" to solutionUsed,
        "categoryAnswer" to categoryAnswer,
        "specificAnswer" to specificAnswer
    )
} }