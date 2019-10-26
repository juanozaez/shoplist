package com.home.shoplist.context.food.domain.create

import com.home.shoplist.context.food.domain.Food
import org.axonframework.test.aggregate.AggregateTestFixture
import org.junit.jupiter.api.Test

class CreateFoodTest {
    private val fixture = AggregateTestFixture(Food::class.java)

    @Test
    fun `it should create a food`() {
        val command = CreateFoodCommand("1", "Avocado")
        val expectedEvent = FoodCreatedEvent("1", "Avocado")

        fixture.givenNoPriorActivity()
                .`when`(command)
                .expectEvents(expectedEvent)
    }
}