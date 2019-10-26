package com.home.shoplist

import com.home.shoplist.context.food.domain.create.CreateFoodCommand
import com.home.shoplist.context.food.domain.delete.DeleteFoodCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID
import javax.inject.Inject

@SpringBootTest
class ShoplistApplicationTests {

    @Inject
    private lateinit var commandBus: CommandGateway

    @Test
    fun `it should create a food`() {
        UUID.randomUUID().toString().run {
            commandBus.sendAndWait<Void>(CreateFoodCommand(this, "Aguacate"))
            commandBus.sendAndWait<Void>(DeleteFoodCommand(this))
        }
    }
}
