package com.home.shoplist.context.food.infrastructure.persistence.jpa

import com.home.shoplist.context.food.domain.query.FoodView
import com.home.shoplist.context.food.domain.query.FoodViewRepository
import org.springframework.data.repository.CrudRepository
import javax.inject.Named

@Named
open class JpaFoodRepository(private val repository: JpaSpringDataFoodRepository) : FoodViewRepository {
    override fun delete(id: String) = repository.deleteById(id)
    override fun find(id: String): FoodView? = repository.findById(id).orElse(null)
    override fun save(view: FoodView) {
        repository.save(view)
    }
}

open interface JpaSpringDataFoodRepository : CrudRepository<FoodView, String>