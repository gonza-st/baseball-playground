package com.gonza.heon.baseballplayground

class Validator {
    fun checkNumber(index: Int, target: String, answer: String): Boolean {
        val digit = answer[index]

        return digit in target
    }

    fun checkDigit(index: Int, target: String, answer: String): Boolean {
        val digit = answer[index]
        val targetDigit = target[index]

        return digit == targetDigit
    }

    fun isCorrect(target: String, answer: String): Boolean {
        return target == answer
    }

    fun checkNumberLength(target: String) {
        if (target.length > BaseballConstants.NUMBER_LENGTH) {
            throw IllegalArgumentException("Number length must be greater than $BaseballConstants.NUMBER_LENGTH")
        }
    }

    fun checkFlag(target: String) {
        if (target.length > 1 || target.isBlank()) {
            throw IllegalArgumentException("Flag length must be between 1")
        }

        if (!target.first().isDigit()) {
            throw IllegalArgumentException("Flag must be a Number")
        }
    }
}