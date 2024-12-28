package com.gonza.heon.baseballplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@SpringBootApplication
class BaseballPlaygroundApplication

fun main(args: Array<String>) {
//    runApplication<BaseballPlaygroundApplication>(*args)
    val validator = Validator()
    val inputView = InputView.getInstance()
    val resultView = ResultView.getInstance()
    val ballPark = BallPark(
        validator = validator,
        inputView = inputView,
        resultView = resultView
    )

    ballPark.play()
}
