package com.example.microservices.product.domain.service

import com.example.microservices.product.domain.model.dto.ProductDto

interface ProductService {
    fun findAll(): Collection<ProductDto>
    fun findByEan(ean: String): ProductDto?
    companion object
}