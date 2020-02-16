package com.ohme.gfl

import com.ohme.gfl.pattern.Glider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GflApplication

fun main(args: Array<String>) {
    runApplication<GflApplication>(*args)
    Glider().start()
}
