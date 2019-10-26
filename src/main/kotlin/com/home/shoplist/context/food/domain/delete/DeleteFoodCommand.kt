package com.home.shoplist.context.food.domain.delete

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class DeleteFoodCommand(@TargetAggregateIdentifier val id: String)