package com.gonza.heon.baseballplayground

class InputView private constructor() {


    fun answer(): String {
        print(INPUT_MESSAGE)
        val number = readlnOrNull().orEmpty()
        return number
    }

    companion object {
        private const val INPUT_MESSAGE = "숫자를 입력해 주세요 : "
        private var instance: InputView? = null

        fun getInstance(): InputView {
            return instance ?: InputView().apply {
                instance = this
            }
        }
    }
}
