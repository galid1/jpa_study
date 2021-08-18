package com.galid.jpa_test.lock

import com.galid.jpa_test.lock.card.Card
import com.galid.jpa_test.lock.card.CardRepository
import com.galid.jpa_test.lock.user.User
import com.galid.jpa_test.lock.user.UserRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.EntityManager
import kotlin.random.Random.Default.nextInt

@Service
@Transactional
class TestService(
    private val userRepository: UserRepository,
    private val em: EntityManager
): InitializingBean {
    var userId: Long? = null

    fun test() {
        val newCard = Card(serialNum = Random().nextInt())

        val foundUser = userRepository.findById(userId!!)
            .get()

        foundUser.addCard(newCard)
        userRepository.save(foundUser)
    }

    override fun afterPropertiesSet() {
        val user: User = User(name = "JJY")
        userId = userRepository.save(user)
            .id
    }
}