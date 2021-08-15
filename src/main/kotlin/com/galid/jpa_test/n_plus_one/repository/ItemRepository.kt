package com.galid.jpa_test.n_plus_one.repository

import com.galid.jpa_test.n_plus_one.domain.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<Item, Long> {
}