package com.home.shoplist.context.food.domain.create

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CreateFoodCommand(@TargetAggregateIdentifier val id: String, val name: String)