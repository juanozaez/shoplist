package com.home.shoplist.context.food.domain.query.by_id

import com.home.shoplist.context.food.domain.query.FoodResponse
import com.home.shoplist.context.food.domain.query.FoodView
import com.home.shoplist.context.food.domain.query.FoodViewRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindFoodByIdTest {

    private val repository: FoodViewRepository = mockk(relaxed = true)
    private val handler = FindFoodByIdQueryHandler(repository)

    @Test
    fun `it should find a food by id`() {
        val query = FindFoodByIdQuery("1")
        val expected = FoodResponse("1", "Pear")
        shouldFindFood()

        val foodResponse = handler.on(query)

        assertEquals(expected, foodResponse)
    }

    private fun shouldFindFood() {
        every { repository.find("1") } returns FoodView("1", "Pear")
    }
}