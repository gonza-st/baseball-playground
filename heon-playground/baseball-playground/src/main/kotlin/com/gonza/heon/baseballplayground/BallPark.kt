package com.gonza.heon.baseballplayground

import java.util.*

class BallPark {

    private val inputView = InputView.getInstance()
    private val resultView = ResultView.getInstance()

    fun play() {
        val target = generateNumber()
        inning(target)
    }

    private fun inning(target: Ball) {
        val answer = inputView.answer()
        val isCorrect = target.isEquals(answer)

        if (isCorrect) {
            resultView.printResult(CONGRATS)
            shouldReplayGame()
        }

        val scoreBoard = target.checkBall(answer)
        val hint = createHint(ballCount = scoreBoard.ballCount, strikeCount = scoreBoard.strikeCount)
        resultView.printResult(hint)

        return inning(target)
    }

    private fun generateNumber(): Ball {
        val random = Random()
        val strBuffer = StringBuffer()

        for (i in 0 until NUMBER_LENGTH) {
            val digit = random.nextInt(10)
            strBuffer.append(digit)
        }
        val target = strBuffer.toString()

        return Ball(target)
    }

    private fun createHint(ballCount: Int, strikeCount: Int): String {
        val stringBuffer = StringBuffer()

        if (ballCount > 0) {
            val ballStr = "${ballCount}볼 "
            stringBuffer.append(ballStr)
        }

        if (strikeCount > 0) {
            val strikeStr = "${strikeCount}스트라이크"
            stringBuffer.append(strikeStr)
        }

        return stringBuffer.toString()
    }

    private fun shouldReplayGame(): Boolean {
        // TODO INPUT_MESSAGE
        val input = inputView.answer()
        val isInvalid = input.length > 1 || input.isBlank()

        if (isInvalid) return shouldReplayGame()

        val digit = input.first()
        if (!digit.isDigit()) return shouldReplayGame()
        if (digit.digitToInt() == REPLAY) return true

        return false
    }

    companion object {
        private const val NUMBER_LENGTH = 3
        private const val CONGRATS = "${NUMBER_LENGTH}의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        private const val REPLAY = 1
        private const val GAME_OVER = 2
    }
}
