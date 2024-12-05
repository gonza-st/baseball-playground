package com.gonza.heon.baseballplayground

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BaseballTest {

    @Test
    fun `갈은 수가 전혀 없는 경우 Nothing 을 반환한다`() {
        val expectedNumber = BaseBallNumber("123")
        val inputNumber = BaseBallNumber("456")

        assertEquals(expectedNumber, inputNumber)
    }

    @Test
    fun `같은 수가 같은 자리에 있으면 스트라이크를 반환한다`() {
        val expectedNumber = BaseBallNumber("123")
        val inputNumber = BaseBallNumber("145")

        assertEquals(expectedNumber, inputNumber)
    }

    @Test
    fun `같은 수가 다른 자리에 있으면 볼을 반환한다`() {
        val expectedNumber = BaseBallNumber("123")
        val inputNumber = BaseBallNumber("415")

        assertEquals(expectedNumber, inputNumber)
    }

    @Test
    fun `숫자가 일치하는 경우 승리한다`() {
        val expectedNumber = BaseBallNumber("123")
        val inputNumber = BaseBallNumber("123")

        assertEquals(expectedNumber, inputNumber)
    }
}