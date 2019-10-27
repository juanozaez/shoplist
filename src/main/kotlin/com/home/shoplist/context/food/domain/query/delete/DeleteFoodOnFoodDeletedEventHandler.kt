package com.home.shoplist.context.food.domain.query.delete

import com.home.shoplist.context.food.domain.delete.FoodDeletedEvent
import com.home.shoplist.context.food.domain.query.FoodViewRepository
import org.axonframework.eventhandling.EventHandler
import javax.inject.Named

@Named
class DeleteFoodOnFoodDeletedEventHandler(private val foodViewRepository: FoodViewRepository) {

    @EventHandler
    fun on(event: FoodDeletedEvent) {
        foodViewRepository.delete(event.id)
    }
}