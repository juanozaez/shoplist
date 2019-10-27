package com.home.shoplist.context.food.domain.query.save

import com.home.shoplist.context.food.domain.create.FoodCreatedEvent
import com.home.shoplist.context.food.domain.query.FoodView
import com.home.shoplist.context.food.domain.query.FoodViewRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class SaveFoodOnFoodCreatedTest {

    private val repository: FoodViewRepository = mockk(relaxed = true)
    private val handler = SaveFoodOnFoodCreatedEventHandler(repository)

    @Test
    fun `it should save a food view on Food created event`() {
        val event = FoodCreatedEvent("1", "Pear")

        handler.on(event)

        verifyFoodViewSaved()
    }

    private fun verifyFoodViewSaved() {
        verify { repository.save(FoodView("1", "Pear")) }
    }
}