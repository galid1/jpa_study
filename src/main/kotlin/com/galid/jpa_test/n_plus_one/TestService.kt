package com.galid.jpa_test.n_plus_one

import com.galid.jpa_test.n_plus_one.domain.Member
import com.galid.jpa_test.n_plus_one.domain.Team
import com.galid.jpa_test.n_plus_one.repository.MemberRepository
import com.galid.jpa_test.n_plus_one.repository.TeamRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Service
@Transactional
class TestService(
    private val memberRepository: MemberRepository,
    private val teamRepository: TeamRepository,
    private val em: EntityManager
) : InitializingBean {

    fun getMember() {
        em.createQuery("select m from Member m", Member::class.java)
            .resultStream
            .forEach {
                println("member : ${it.name}")
            }
    }

    var member1Id = 0L
    var member2Id = 0L

    override fun afterPropertiesSet() {
        val team1 = Team(name = "T1")
        val team2 = Team(name = "T2")
        teamRepository.saveAll(listOf(team1, team2))

        val member1 = Member(name = "m1", team = team1)
        member1Id = memberRepository.save(member1).id!!
        val member2 = Member(name = "m2", team = team2)
        member2Id = memberRepository.save(member2).id!!
    }
}
