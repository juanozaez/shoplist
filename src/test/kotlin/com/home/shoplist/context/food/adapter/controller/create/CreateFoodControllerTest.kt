package com.home.shoplist.context.food.adapter.controller.create

import com.home.shoplist.context.food.domain.query.FoodResponse
import com.home.shoplist.context.food.domain.query.by_id.FindFoodByIdQuery
import com.home.shoplist.shared.awaitAssertionOk
import org.axonframework.queryhandling.QueryGateway
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import javax.inject.Inject


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateFoodControllerTest {

    @LocalServerPort
    private val serverPort: Int = 0

    @Inject
    private lateinit var restTemplate: TestRestTemplate

    @Inject
    private lateinit var queryGateway: QueryGateway

    @Test
    fun `it should create a food`() {
        val request = CreateFoodRestRequest("1", "Pear")
        val expected = FoodResponse("1", "Pear")
        restTemplate.postForObject("http://localhost:$serverPort/shoplist/foods", request, Void::class.java)

        awaitAssertionOk {
            val response = queryGateway.query(FindFoodByIdQuery("1"), FoodResponse::class.java).get()
            assertEquals(expected, response)
        }
    }
}