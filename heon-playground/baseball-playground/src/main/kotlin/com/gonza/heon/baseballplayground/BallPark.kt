package com.gonza.heon.baseballplayground

import java.util.*

class BallPark {

    private val inputView = InputView.getInstance()
    private val resultView = ResultView.getInstance()

    fun play() {
        val target = generateNumber()

    }

    private fun inning(target: BaseBallNumber) {
        val answer = inputView.answer()
        val isCorrect = target.isEquals(answer)

        if (isCorrect) {

        }

        return inning(target)
    }

    private fun generateNumber(): BaseBallNumber {
        val random = Random()
        val strBuffer = StringBuffer()

        for (i in 0 until NUMBER_LENGTH) {
            val digit = random.nextInt(10)
            strBuffer.append(digit)
        }
        val target = strBuffer.toString()

        return BaseBallNumber(target)
    }

    companion object {
        private const val NUMBER_LENGTH = 3
    }
}
