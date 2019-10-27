package com.home.shoplist

import com.home.shoplist.context.food.domain.create.CreateFoodCommand
import com.home.shoplist.context.food.domain.query.FoodResponse
import com.home.shoplist.context.food.domain.query.by_id.FindFoodByIdQuery
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.lang.Thread.sleep
import java.util.UUID
import javax.inject.Inject

@SpringBootTest
class ShoplistApplicationTests {

    @Inject
    private lateinit var commandBus: CommandGateway

    @Inject
    private lateinit var queryBus: QueryGateway

    @Test
    fun `it should create a food`() {
        UUID.randomUUID().toString().run {
            val expected = FoodResponse(this, "Aguacate")
            commandBus.sendAndWait<Void>(CreateFoodCommand(this, "Aguacate"))
            // commandBus.sendAndWait<Void>(DeleteFoodCommand(this))
            sleep(2000)
            val response = queryBus.query(FindFoodByIdQuery(this), FoodResponse::class.java).get()
            Assertions.assertEquals(expected, response)
        }
    }
}
