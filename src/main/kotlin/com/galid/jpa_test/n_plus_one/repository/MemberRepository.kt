package com.galid.jpa_test.n_plus_one.repository

import com.galid.jpa_test.n_plus_one.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
}