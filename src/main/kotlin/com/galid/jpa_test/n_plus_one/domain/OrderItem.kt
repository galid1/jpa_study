package com.galid.jpa_test.n_plus_one.domain

import javax.persistence.*

@Entity
class OrderItem (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne
    @JoinColumn(name="order_id")
    var order: Order? = null,
    @OneToOne(fetch = FetchType.LAZY)
    val item: Item
) {
}