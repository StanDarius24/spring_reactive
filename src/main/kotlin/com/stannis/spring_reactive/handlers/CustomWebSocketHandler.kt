package com.stannis.spring_reactive.handlers

import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import reactor.core.publisher.Sinks
import java.lang.StringBuilder

@Component
class CustomWebSocketHandler(sink: Sinks.Many<String>): WebSocketHandler {

    private val sink: Sinks.Many<String>

    init {
        this.sink = sink
    }

    override fun handle(session: WebSocketSession): Mono<Void> {
        val f = session.receive()
            .map { it.payloadAsText }
            .map { it: String ->
                StringBuilder(it).reverse()
                session.textMessage(it)
            }
        
        return session.send(f)
    }

}