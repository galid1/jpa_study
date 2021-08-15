package com.galid.jpa_test.n_plus_one.repository

import com.galid.jpa_test.n_plus_one.domain.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, Long> {
}