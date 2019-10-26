package com.home.shoplist.context.food.domain.delete

import com.home.shoplist.context.food.domain.Food
import com.home.shoplist.context.food.domain.create.FoodCreatedEvent
import org.axonframework.test.aggregate.AggregateTestFixture
import org.junit.jupiter.api.Test

class DeleteFoodTest {
    private val fixture = AggregateTestFixture(Food::class.java)

    @Test
    fun `it should create a food`() {
        val previousEvent = FoodCreatedEvent("1", "Avocado")
        val command = DeleteFoodCommand("1")
        val expectedEvent = FoodDeletedEvent("1")

        fixture.given(previousEvent)
                .`when`(command)
                .expectEvents(expectedEvent)
    }
}