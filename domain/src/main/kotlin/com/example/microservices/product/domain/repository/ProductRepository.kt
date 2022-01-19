package com.example.microservices.product.domain.repository

import com.example.microservices.product.domain.model.dto.ProductRepositoryDto

interface ProductRepository {
    fun findAll(): Collection<ProductRepositoryDto>
    fun findByEan(ean: String): ProductRepositoryDto?
}
