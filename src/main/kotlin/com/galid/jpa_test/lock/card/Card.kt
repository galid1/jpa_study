package com.galid.jpa_test.lock.card

import com.galid.jpa_test.lock.user.User
import javax.persistence.*

@Entity
@Table(name = "card")
class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val serialNum: Int,
    var userId: Long? = null,
) {
    fun setUser(user: User) {
        this.userId = user.id
    }
}