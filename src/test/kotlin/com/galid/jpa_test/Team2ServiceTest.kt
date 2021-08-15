package com.galid.jpa_test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class Team2ServiceTest {
    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var teamRepository: TeamRepository

    @Autowired
    lateinit var teamService: TeamService

    var teamId: Long = 0

    @BeforeEach
    fun init() {
        teamId = teamService.saveTeam()
    }

    @AfterEach
    fun after() {
        memberRepository.deleteAll()
        teamRepository.deleteAll()
    }

    @Test
    fun `Lazy Loading으로 인한 N+1`() {
        println("============================ get ========================")
        // when
        teamService.getMembers(teamId)
        // then
        println("==========================================================")
    }
}