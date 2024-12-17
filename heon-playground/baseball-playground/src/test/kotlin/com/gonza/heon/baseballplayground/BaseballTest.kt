package com.gonza.heon.baseballplayground

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BaseballTest {

    @Test
    fun `갈은 수가 전혀 없는 경우 Nothing 을 반환한다`() {
        val expectedNumber = Ball("123")
        val inputNumber = Ball("456")

        val result = expectedNumber.checkBall(inputNumber.number)

        assertEquals(result.ballCount, 0)
        assertEquals(result.strikeCount, 0)
    }

    @Test
    fun `같은 수가 같은 자리에 있으면 스트라이크를 반환한다`() {
        val expectedNumber = Ball("123")
        val inputNumber = Ball("145")

        val result = expectedNumber.checkBall(inputNumber.number)

        assertEquals(result.ballCount, 0)
        assertEquals(result.strikeCount, 1)
    }

    @Test
    fun `같은 수가 다른 자리에 있으면 볼을 반환한다`() {
        val expectedNumber = Ball("123")
        val inputNumber = Ball("415")

        val result = expectedNumber.checkBall(inputNumber.number)

        assertEquals(result.ballCount, 1)
        assertEquals(result.strikeCount, 0)
    }

    @Test
    fun `숫자가 일치하는 경우 승리한다`() {
        val expectedNumber = Ball("123")
        val inputNumber = Ball("123")

        val result = expectedNumber.isEquals(inputNumber.number)

        assertTrue(result)
    }
}