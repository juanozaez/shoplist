package com.home.shoplist.context.food.adapter.subscriber.create

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.home.shoplist.context.food.domain.query.FoodResponse
import com.home.shoplist.context.food.domain.query.by_id.FindFoodByIdQuery
import com.home.shoplist.shared.awaitAssertionOk
import org.axonframework.queryhandling.QueryGateway
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.boot.test.context.SpringBootTest
import javax.inject.Inject

@SpringBootTest
class CreateFoodSubscriberTest {

    @Inject
    private lateinit var queryGateway: QueryGateway

    @Inject
    private lateinit var amqpTemplate: AmqpTemplate

    @Test
    fun `it should create a food`() {
        val request = CreateFoodQueueRequest("1", "Pear")
        val expected = FoodResponse("1", "Pear")

        amqpTemplate.convertAndSend("create_food", jacksonObjectMapper().writeValueAsString(request))

        awaitAssertionOk {
            val response = queryGateway.query(FindFoodByIdQuery("1"), FoodResponse::class.java).get()
            assertEquals(expected, response)
        }
    }
}