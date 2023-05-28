package com.reactive.client.config

import com.reactive.client.handlers.ProductHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration
class RoutesConfig {

    @Bean
    fun router(productHandler: ProductHandler): RouterFunction<ServerResponse> {
        return route().GET("/all", productHandler::getAll)
            .build()
    }

}