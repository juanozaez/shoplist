package com.home.shoplist.context.food.adapter.subscriber.create

data class CreateFoodQueueRequest(val id: String, val name: String){
    constructor() : this("", "")
}