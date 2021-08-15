package com.galid.jpa_test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaTestApplication

fun main(args: Array<String>) {
    runApplication<JpaTestApplication>(*args)
}
