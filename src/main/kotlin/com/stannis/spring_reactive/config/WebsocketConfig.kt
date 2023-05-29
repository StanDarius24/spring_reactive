package com.stannis.spring_reactive.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter
import reactor.core.publisher.Sinks

@Configuration
class WebsocketConfig {

    @Bean
    fun handlerMapping(wsh: WebSocketHandler): SimpleUrlHandlerMapping {
        return SimpleUrlHandlerMapping(mapOf("/ws/message" to wsh), 1)
    }

    @Bean
    fun webSocketHandlerAdapter(): WebSocketHandlerAdapter {
        return WebSocketHandlerAdapter()
    }

    @Bean
    fun sink(): Sinks.Many<String> {
        return Sinks.many().multicast().directBestEffort()
    }

}