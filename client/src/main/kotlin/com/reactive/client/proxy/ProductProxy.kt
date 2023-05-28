package com.reactive.client.proxy

import com.reactive.client.model.Product
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux


@Component
class ProductProxy(private val webClient: WebClient) {

    fun getAll(): Flux<Product> {
        val p = Product()
        p.name = "default"

        return webClient.get().uri("/products")
            .exchangeToFlux { res: ClientResponse ->
                res.bodyToFlux(
                    Product::class.java
                )
            }

//            .onErrorResume { Flux.just(p) } // how to handle exceptions (do not use this approach)

//            .onErrorResume(WebClientRequestException::class.java) {
//                Flux.just(p)
//            }                              // a more formal method

//            .onErrorResume(
//                { it.message == null }
//            ) {
//                Flux.just(p)
//            }                              // check type of exception
            .doOnNext {
                if (it.name == null)
                    throw RuntimeException()
            }
            .onErrorContinue { e: Throwable, _: Any -> print(e.message)}               // an item is wrong


    }
}