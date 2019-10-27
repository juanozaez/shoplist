package com.home.shoplist.context.food.domain.query.delete

import com.home.shoplist.context.food.domain.delete.FoodDeletedEvent
import com.home.shoplist.context.food.domain.query.FoodViewRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class DeleteFoodOnFoodDeletedTest {

    private val repository: FoodViewRepository = mockk(relaxed = true)
    private val handler = DeleteFoodOnFoodDeletedEventHandler(repository)

    @Test
    fun `it should delete a food view on Food deleted event`() {
        val event = FoodDeletedEvent("1")

        handler.on(event)

        verifyFoodViewDeleted()
    }

    private fun verifyFoodViewDeleted() {
        verify { repository.delete("1") }
    }
}