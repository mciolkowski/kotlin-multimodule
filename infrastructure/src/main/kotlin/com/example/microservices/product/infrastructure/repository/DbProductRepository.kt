package com.example.microservices.product.infrastructure.repository

import com.example.microservices.product.domain.model.dto.ProductRepositoryDto
import com.example.microservices.product.domain.repository.ProductRepository
import org.springframework.stereotype.Component

@Component
class DbProductRepository: ProductRepository {
    override fun findAll(): Collection<ProductRepositoryDto> =
        listOf(ProductRepositoryDto("123", "name", "desc"))

    override fun findByEan(ean: String): ProductRepositoryDto? = null
}