package com.gonza.heon.baseballplayground

class InputView {
    fun answer(): String {
        val number = readlnOrNull().orEmpty()
        return number
    }
}
