package com.home.shoplist.context.food.domain.query.save

import com.home.shoplist.context.food.domain.create.FoodCreatedEvent
import com.home.shoplist.context.food.domain.query.FoodView
import com.home.shoplist.context.food.domain.query.FoodViewRepository
import org.axonframework.eventhandling.EventHandler
import javax.inject.Named

@Named
class SaveFoodOnFoodCreatedEventHandler(private val foodViewRepository: FoodViewRepository) {

    @EventHandler
    fun on(event: FoodCreatedEvent) {
        foodViewRepository.save(FoodView(event.id, event.name))
    }
}