package com.home.shoplist

import com.home.shoplist.context.food.domain.create.CreateFoodCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.inject.Inject

@SpringBootTest
class ShoplistApplicationTests {

    @Inject
    private lateinit var commandBus: CommandGateway

    @Test
    fun `it should create a food`() {
        commandBus.sendAndWait<Void>(CreateFoodCommand("1", "Aguacate"))
    }
}
