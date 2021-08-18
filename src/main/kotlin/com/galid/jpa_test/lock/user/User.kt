package com.galid.jpa_test.lock.user

import com.galid.jpa_test.lock.card.Card
import javax.persistence.*

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val name: String,
    @OneToMany(cascade = [CascadeType.PERSIST])
    val cards: MutableSet<Card> = HashSet()
) {

    fun addCard(card: Card) {
        if(isMaximumCardCount())
            throw RuntimeException("카드 수량 한도를 초과")

        card.setUser(this)
        this.cards.add(card)
    }

    private fun isMaximumCardCount(): Boolean {
        return this.cards.size == MAX_CARD_COUNT
    }

    companion object {
        const val MAX_CARD_COUNT = 2
    }
}