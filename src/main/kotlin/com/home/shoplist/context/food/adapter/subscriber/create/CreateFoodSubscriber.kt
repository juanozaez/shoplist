package com.home.shoplist.context.food.adapter.subscriber.create

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.home.shoplist.context.food.domain.create.CreateFoodCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.amqp.rabbit.annotation.RabbitListener
import javax.inject.Named

@Named
open class CreateFoodSubscriber(private val commandGateway: CommandGateway) {

    private val mapper = jacksonObjectMapper()

    @RabbitListener(queues = ["create_food"])
    open fun process(request: String) {
        val request = mapper.readValue(request, CreateFoodQueueRequest::class.java)
        commandGateway.send<Void>(CreateFoodCommand(request.id, request.name))
    }
}