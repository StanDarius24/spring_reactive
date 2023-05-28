package com.reactive.client.service

import com.reactive.client.model.Product
import com.reactive.client.proxy.ProductProxy
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@Service
class ProductService(private val proxy: ProductProxy) {

    fun getAll(): Flux<Product> {
        return proxy.getAll()
    }
}