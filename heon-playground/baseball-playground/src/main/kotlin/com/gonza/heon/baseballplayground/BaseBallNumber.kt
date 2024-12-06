package com.gonza.heon.baseballplayground

import java.util.*

data class BaseBallNumber(
    val number: String = "",
) {
    private val numberLength = 3

    // FIXME : 호출 시마다 난수가 생성됨
    val target: String
        get() {
            if (number.isNotEmpty()) {
                return number
            }

            return generateNumber()
        }

    private fun generateNumber(): String {
        val random = Random()
        val strBuffer = StringBuffer()

        for (i in 0 until numberLength) {
            val digit = random.nextInt(10)
            strBuffer.append(digit)
        }
        val target = strBuffer.toString()

        return target
    }

}
