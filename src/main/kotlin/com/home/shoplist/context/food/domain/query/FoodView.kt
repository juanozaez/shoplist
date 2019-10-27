package com.home.shoplist.context.food.domain.query

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class FoodView(@Id val id: String, val name: String) {
    // TODO for JPA purposes, remove ASAP
    constructor() : this("", "")
}