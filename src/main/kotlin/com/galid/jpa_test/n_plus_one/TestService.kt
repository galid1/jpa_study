package com.galid.jpa_test.n_plus_one

import com.galid.jpa_test.n_plus_one.domain.Item
import com.galid.jpa_test.n_plus_one.domain.Member
import com.galid.jpa_test.n_plus_one.domain.Order
import com.galid.jpa_test.n_plus_one.domain.OrderItem
import com.galid.jpa_test.n_plus_one.repository.ItemRepository
import com.galid.jpa_test.n_plus_one.repository.MemberRepository
import com.galid.jpa_test.n_plus_one.repository.OrderRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TestService(
    private val orderRepository:OrderRepository,
    private val itemRepository: ItemRepository,
    private val memberRepository: MemberRepository
): InitializingBean {

    fun service() {
        orderRepository.findAll()
            .forEach {
                println("===================")
                println("주문 회원 : ${it.member.name}")
                println("=== 주문 목록 ===")
                it.orderItems.forEach { oi ->
                    println("상품 이름 : ${oi.item.name}")
                }
            }
    }

    override fun afterPropertiesSet() {
        val member1 = Member(name = "jY")
        val member2 = Member(name = "GA")
        memberRepository.saveAll(
            listOf(
                member1,
                member2
            )
        )

        val item1 = Item(name = "JPA BOOK")
        val item2 = Item(name = "Pencil")
        val item3 = Item(name = "Remote Controller")
        itemRepository.saveAll(
            listOf(
                item1,
                item2,
                item3
            )
        )

        val order1 = Order(
            member = member1,
            orderItems = listOf(
                OrderItem(item = item1),
                OrderItem(item = item2)
            )
        )

        val order2 = Order(
            member = member2,
            orderItems = listOf(
                OrderItem(item = item3),
                OrderItem(item = item2)
            )
        )

        orderRepository.saveAll(listOf(
            order1, order2
        ))
    }


}