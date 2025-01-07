package com.gonza.heon.baseballplayground

class ResultView private constructor() {
    fun printResult(message: String) {
        println(message)
    }

    companion object {
        private var instance : ResultView? = null

        fun getInstance(): ResultView {
            return instance ?: ResultView().apply {
                instance = this
            }
        }
    }
}
