package com.home.shoplist.context.food.domain

import com.home.shoplist.context.food.domain.create.CreateFoodCommand
import com.home.shoplist.context.food.domain.create.FoodCreatedEvent
import com.home.shoplist.context.food.domain.delete.DeleteFoodCommand
import com.home.shoplist.context.food.domain.delete.FoodDeletedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class Food constructor() {
    @AggregateIdentifier
    private lateinit var id: String
    private lateinit var name: String
    private var active: Boolean = true

    @CommandHandler
    constructor (command: CreateFoodCommand) : this() {
        AggregateLifecycle.apply(FoodCreatedEvent(command.id, command.name))
    }

    @CommandHandler
    fun on(command: DeleteFoodCommand) {
        AggregateLifecycle.apply(FoodDeletedEvent(id))
    }

    @EventSourcingHandler
    fun on(event: FoodCreatedEvent) {
        id = event.id
        name = event.name
        active = true
    }

    @EventSourcingHandler
    fun on(event: FoodDeletedEvent) {
        id = event.id
        active = false
    }
}