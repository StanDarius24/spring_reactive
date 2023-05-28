package com.stannis.spring_reactive.services

import com.stannis.spring_reactive.model.Product
import com.stannis.spring_reactive.repositories.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration


@Service
class ProductService(productRepository: ProductRepository) {

    private val productRepository: ProductRepository

    init {
        this.productRepository = productRepository
    }


    fun getProducts(): Flux<Product> { // whole method takes 10 seconds to execute
        return productRepository.findAll() // 2 products
                .delayElements(Duration.ofSeconds(5)) // for any element add a sleep duration
    }

    fun getProductsButInADifferentWay(): Flux<Product> {
        val p1 = Product()
        p1.name = "test1"
        val p2 = Product()
        p2.name = "test2"

        return Flux.fromStream(
                listOf(p1, p2).stream()
        )
    }

}