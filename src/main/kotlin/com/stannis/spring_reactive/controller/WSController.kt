package com.stannis.spring_reactive.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.Many

@RestController
class WSController(sink: Many<String>) {

    private val sink: Many<String>

    init {
        this.sink =sink
    }


    @PostMapping("/demo")
    fun demo() {
        sink.emitNext("hello", Sinks.EmitFailureHandler.FAIL_FAST)
    }

}