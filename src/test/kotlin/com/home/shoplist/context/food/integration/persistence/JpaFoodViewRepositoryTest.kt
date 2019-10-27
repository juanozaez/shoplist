package com.home.shoplist.context.food.integration.persistence

import com.home.shoplist.context.food.domain.query.FoodView
import com.home.shoplist.context.food.domain.query.FoodViewRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.inject.Inject

@SpringBootTest
class JpaFoodViewRepositoryTest {

    @Inject
    private lateinit var jpaFoodViewRepository: FoodViewRepository

    @Test
    fun `it should save and find food view`() {
        val foodView = FoodView("1", "Pear")
        jpaFoodViewRepository.save(foodView)

        assertEquals(foodView, jpaFoodViewRepository.find("1"))
    }

    @Test
    fun `it should delete food view`() {
        val foodView = FoodView("1", "Pear")
        jpaFoodViewRepository.save(foodView)

        jpaFoodViewRepository.delete("1")

        assertNull(jpaFoodViewRepository.find("1"))
    }
}