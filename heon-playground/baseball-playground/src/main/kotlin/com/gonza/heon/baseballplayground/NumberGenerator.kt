package com.gonza.heon.baseballplayground

import java.util.*

object NumberGenerator {
    fun generate(): Ball {
        val random = Random()
        val strBuffer = StringBuffer()

        for (i in 0 until BaseballConstants.NUMBER_LENGTH) {
            val digit = random.nextInt(BaseballConstants.NUMBER_ORIGIN, BaseballConstants.NUMBER_BOUND)
            strBuffer.append(digit)
        }
        val target = strBuffer.toString()

        return Ball(target)
    }

}