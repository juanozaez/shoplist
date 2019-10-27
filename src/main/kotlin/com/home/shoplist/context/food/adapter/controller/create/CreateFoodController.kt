package com.home.shoplist.context.food.adapter.controller.create

import com.home.shoplist.context.food.domain.create.CreateFoodCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI


@RestController
open class CreateFoodController(private val commandGateway: CommandGateway) {

    @PostMapping("/shoplist/foods")
    open fun create(@RequestBody request: CreateFoodRestRequest): ResponseEntity<Void> {
        commandGateway.send<Void>(CreateFoodCommand(request.id, request.name))
        return ResponseEntity.created(URI("/shoplist/foods/${request.id}")).build<Void>()
    }
}

