package com.stannis.spring_reactive.repositories

import com.stannis.spring_reactive.model.Product
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ProductRepository: ReactiveCrudRepository<Product, Long>