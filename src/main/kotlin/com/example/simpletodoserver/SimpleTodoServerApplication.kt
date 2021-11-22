package com.example.simpletodoserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleTodoServerApplication

fun main(args: Array<String>) {
	runApplication<SimpleTodoServerApplication>(*args)
}
