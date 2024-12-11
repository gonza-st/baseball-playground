package com.gonza.heon.baseballplayground

import java.util.*

class BallPark {
    fun play() {
        val correct = generateNumber()


    }

    private fun inning(correct: BaseBallNumber) {
        // TODO while 대신 재귀적 방식으로 풀기 ?
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
