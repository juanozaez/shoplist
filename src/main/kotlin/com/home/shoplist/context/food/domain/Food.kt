package com.home.shoplist.context.food.domain

import com.home.shoplist.context.food.domain.create.CreateFoodCommand
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class Food {
    @AggregateIdentifier
    private lateinit var id: String
    private lateinit var name: String

    @CommandHandler
    constructor(command: CreateFoodCommand){
        AggregateLifecycle.apply(FoodCreatedEvent(command.id, command.name))
    }

    @EventSourcingHandler
    fun on(event: FoodCreatedEvent) {
        id = event.id
        name = event.name
    }
}