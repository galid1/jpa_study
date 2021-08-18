package com.galid.jpa_test.lock

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService
) {
    @PostMapping("/")
    fun test() {
        testService.test()
    }
}