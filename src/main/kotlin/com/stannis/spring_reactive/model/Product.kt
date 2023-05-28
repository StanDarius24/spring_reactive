package com.stannis.spring_reactive.model

import org.springframework.data.annotation.Id


class Product {
    @Id
    var id = 0
    var name: String? = null
}