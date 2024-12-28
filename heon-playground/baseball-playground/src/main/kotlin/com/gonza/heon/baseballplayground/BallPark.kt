package com.gonza.heon.baseballplayground

class BallPark(
    private val validator: Validator,
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun play() {
        val target = NumberGenerator.generate()
        val scoreBoard = ScoreBoard()
        inning(ball = target, scoreBoard = scoreBoard)

        if (shouldReplayGame()) {
            play()
        }
    }

    fun inning(ball: String, scoreBoard: ScoreBoard) {
        val answer = inputView.answer()
        validator.checkNumberLength(answer)

        counting(ball = ball, answer = answer, scoreBoard = scoreBoard)

        val isCorrect = validator.isCorrect(ball, answer)
        if (isCorrect) {
            resultView.printResult(BaseballConstants.CONGRATS)
            return
        }

        resultView.printResult(scoreBoard.hint())
        scoreBoard.clearCount()

        return inning(ball = ball, scoreBoard = scoreBoard)
    }

    private fun counting(ball: String, answer: String, scoreBoard: ScoreBoard) {
        for (index in answer.indices) {
            val isBall = validator.checkNumber(index = index, target = ball, answer = answer)
            val isStrike = validator.checkDigit(index = index, target = ball, answer = answer)

            if (isBall) scoreBoard.increaseBallCount()
            if (isStrike) {
                scoreBoard.decreaseBallCount()
                scoreBoard.increaseStrikeCount()
            }
        }
    }

    private fun getReplayFlag(): Int {
        val input = inputView.answer()
        validator.checkFlag(input)

        val digit = input.first().digitToInt()
        return digit
    }

    private fun shouldReplayGame(): Boolean {
        val flag = getReplayFlag()
        return flag == BaseballConstants.REPLAY_FLAG
    }
}
