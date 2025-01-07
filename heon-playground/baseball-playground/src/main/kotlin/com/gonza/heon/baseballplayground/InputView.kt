package com.gonza.heon.baseballplayground

class InputView private constructor() {


    fun answer(): String {
        val number = readlnOrNull().orEmpty()
        return number
    }

    companion object {
        private var instance: InputView? = null

        fun getInstance(): InputView {
            return instance ?: InputView().apply {
                instance = this
            }
        }
    }
}
