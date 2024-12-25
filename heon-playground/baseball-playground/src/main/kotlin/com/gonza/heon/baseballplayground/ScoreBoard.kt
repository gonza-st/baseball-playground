package com.gonza.heon.baseballplayground

data class ScoreBoard(
    private var ballCount: Int,
    private var strikeCount: Int,
) {
    fun increaseBallCount(): Int {
        ballCount++

        return ballCount
    }

    fun increaseStrikeCount(): Int {
        strikeCount++

        return strikeCount
    }

    fun decreaseBallCount(): Int {
        ballCount--

        return ballCount
    }

    fun decreaseStrikeCount(): Int {
        strikeCount--

        return strikeCount
    }

    private fun clearCount() {
        ballCount = 0
        strikeCount = 0
    }
}
