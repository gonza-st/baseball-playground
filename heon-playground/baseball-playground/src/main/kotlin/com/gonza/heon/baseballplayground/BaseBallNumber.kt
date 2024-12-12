package com.gonza.heon.baseballplayground

data class BaseBallNumber(
    val number: String = "",
) {
    fun isEquals(answer: String): Boolean =
        this.number == answer.number
}
