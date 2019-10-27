package com.home.shoplist.context.food.domain.query.by_id

import com.home.shoplist.context.food.domain.query.FoodViewRepository
import com.home.shoplist.context.food.domain.query.toResponse
import org.axonframework.queryhandling.QueryHandler
import javax.inject.Named

@Named
open class FindFoodByIdQueryHandler(private val repository: FoodViewRepository) {

    @QueryHandler
    fun on(query: FindFoodByIdQuery) = repository.find(query.id)?.toResponse()
}