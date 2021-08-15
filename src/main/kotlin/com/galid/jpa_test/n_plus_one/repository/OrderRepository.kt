package com.galid.jpa_test.n_plus_one.repository

import com.galid.jpa_test.n_plus_one.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
}