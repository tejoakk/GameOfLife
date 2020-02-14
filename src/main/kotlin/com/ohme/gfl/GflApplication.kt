package com.ohme.gfl

import com.ohme.gfl.service.Play
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GflApplication

fun main(args: Array<String>) {
    runApplication<GflApplication>(*args)
    Play(25).evolve()
}
