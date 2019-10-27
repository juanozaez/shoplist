package com.home.shoplist.context.food.domain.query

interface FoodViewRepository {
    fun find(id:String): FoodView?
    fun save(view: FoodView)
    fun delete(id: String)
}