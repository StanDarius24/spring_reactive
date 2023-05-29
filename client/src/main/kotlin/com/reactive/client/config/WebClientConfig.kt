package com.reactive.client.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux


@Configuration
class WebClientConfig {

    @Value("\${products.service.base.url}")
    private val baseUrl: String? = null

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl(baseUrl!!)
            .build()
    }
}