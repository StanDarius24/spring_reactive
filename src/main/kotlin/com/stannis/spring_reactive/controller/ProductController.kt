package com.stannis.spring_reactive.controller

import com.stannis.spring_reactive.model.Product
import com.stannis.spring_reactive.services.ProductService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class ProductController(productService: ProductService) {

    // You can do this but it s not usual, you need to define a routes config

    private val productService: ProductService

    init {
        this.productService = productService
    }

    @get:GetMapping(value = ["/product1"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    val product: Flux<Product>
        get() = productService.getProducts()

    @GetMapping(value = ["/product2"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getProducts(): Flux<Product> {
        return productService.getProductsButInADifferentWay()
    }
}