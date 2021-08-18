package com.galid.jpa_test.n_plus_one

import com.galid.jpa_test.n_plus_one.domain.Member
import com.galid.jpa_test.n_plus_one.domain.Team
import com.galid.jpa_test.n_plus_one.repository.MemberRepository
import com.galid.jpa_test.n_plus_one.repository.TeamRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.LockModeType

@Service
@Transactional
class TestService(
    private val memberRepository: MemberRepository,
    private val teamRepository: TeamRepository,
    private val em: EntityManager
) : InitializingBean {

    fun lockTest() {
        em.find(Member::class.java, 1L, LockModeType.PESSIMISTIC_WRITE)
    }

    fun getTeamWithMember() {
        em.createQuery("select t from Team t", Team::class.java)
            .resultList
            .stream()
            .forEach {
                println("team : ${it.name}")
                println("========= members ==========")
                it.members.stream()
                    .forEach { println("member : ${it.name}") }
            }
    }

    override fun afterPropertiesSet() {
        val team1 = Team(name = "T1", members = listOf(
            Member(name = "m1"),
            Member(name = "m2")
        ))

        val team2 = Team(name = "T2", members = listOf(
            Member(name = "m3"),
            Member(name = "m4")
        ))

        val team3 = Team(name = "T3", members = listOf(
            Member(name = "m5"),
            Member(name = "m6")
        ))

        val team4 = Team(name = "T4", members = listOf(
            Member(name = "m7"),
            Member(name = "m8")
        ))
        teamRepository.saveAll(listOf(team1, team2, team3, team4))
    }

}
