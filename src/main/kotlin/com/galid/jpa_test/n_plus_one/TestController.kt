package com.galid.jpa_test.n_plus_one

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService
) {
    @GetMapping
    fun test() {
        testService.getMemberWithTeamByEntityManger()
    }

    @GetMapping("/2")
    fun test2() {
        testService.getMemberWithTeamByRepository()
    }
}