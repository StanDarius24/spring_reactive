package com.reactive.client.handlers

import com.reactive.client.model.Product
import com.reactive.client.service.ProductService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest

import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok

import reactor.core.publisher.Mono


@Component
class ProductHandler(productService: ProductService) {
    private val productService: ProductService

    init {
        this.productService = productService
    }

    fun getAll(request: ServerRequest?): Mono<ServerResponse> {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(productService.getAll(), Product::class.java)
    }
}