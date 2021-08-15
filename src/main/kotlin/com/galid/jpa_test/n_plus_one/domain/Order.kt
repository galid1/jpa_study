package com.galid.jpa_test.n_plus_one.domain

import javax.persistence.*

@Entity(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne
    val member: Member,
    @OneToMany(cascade = [CascadeType.ALL])
    var orderItems: List<OrderItem> = ArrayList()
) {
}