package com.gonza.heon.baseballplayground

data class Ball(
    val number: String,
) {
    private var ballCount: Int = 0

    private var strikeCount: Int = 0

    fun isEquals(answer: String): Boolean =
        this.number == answer

    fun checkBall(answer: String): ScoreBoard {
        for (index in answer.indices) {
//            checkDigit(index = index, answer = answer)
//            checkDigitIndex(index = index, answer = answer)
        }

        val scoreBoard = ScoreBoard(
            ballCount = ballCount,
            strikeCount = strikeCount,
        )
//        clearCount()

        return scoreBoard
    }
}
