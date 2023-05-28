package com.stannis.spring_reactive.config

import com.stannis.spring_reactive.handlers.ProductHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration
class RoutesConfig(productHandler: ProductHandler) {

    private val productHandler: ProductHandler

    init {
        this.productHandler = productHandler
    }

    @Bean
    fun router(): RouterFunction<ServerResponse> {
        return route()
            .GET("/products") {
                productHandler.getAll(it)
            }
            .build()
    }

}