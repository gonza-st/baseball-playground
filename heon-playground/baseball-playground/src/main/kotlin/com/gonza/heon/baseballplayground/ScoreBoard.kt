package com.gonza.heon.baseballplayground

data class ScoreBoard(
    private var ballCount: Int = 0,
    private var strikeCount: Int = 0,
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

    fun clearCount() {
        ballCount = 0
        strikeCount = 0
    }

    fun hint(): String {
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
}
