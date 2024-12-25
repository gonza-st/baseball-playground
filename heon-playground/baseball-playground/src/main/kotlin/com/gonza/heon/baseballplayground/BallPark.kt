package com.gonza.heon.baseballplayground

class BallPark(
    private val inputView: InputView = InputView.getInstance(),
    private val resultView: ResultView = ResultView.getInstance(),
) {
    fun play() {
        val target = NumberGenerator.generate()
        inning(target)

        if (shouldReplayGame()) {
            play()
        }
    }

    private fun inning(target: Ball) {
        val answer = inputView.answer()
        val isCorrect = target.isEquals(answer)

        if (isCorrect) {
            resultView.printResult(CONGRATS)
            return
        }

        val scoreBoard = target.checkBall(answer)
        val hint = createHint(ballCount = scoreBoard.ballCount, strikeCount = scoreBoard.strikeCount)
        resultView.printResult(hint)

        return inning(target)
    }


    private fun createHint(ballCount: Int, strikeCount: Int): String {
        val stringBuffer = StringBuffer()

        if (ballCount == 0 && strikeCount == 0) {
            stringBuffer.append("Nothing")
        }

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
        private const val CONGRATS = "${BaseballConstants.NUMBER_LENGTH}의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        private const val REPLAY = 1
        private const val GAME_OVER = 2
    }
}
