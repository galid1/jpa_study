package com.galid.jpa_test.n_plus_one.domain

import javax.persistence.*

@Entity
class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val name: String,
) {
}