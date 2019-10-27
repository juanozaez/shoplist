package com.home.shoplist.context.food.domain.query

fun FoodView.toResponse() = FoodResponse(id, name)