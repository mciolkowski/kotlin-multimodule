package com.example.microservices.product.domain.service.impl

import com.example.microservices.product.domain.model.Product
import com.example.microservices.product.domain.model.dto.ProductDto
import com.example.microservices.product.domain.model.mapper.fromRepositoryDto
import com.example.microservices.product.domain.model.mapper.toDto
import com.example.microservices.product.domain.repository.ProductRepository
import com.example.microservices.product.domain.service.ProductService

internal class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService{

    override fun findAll(): Collection<ProductDto> =
        productRepository.findAll()
            .map {
                Product.fromRepositoryDto(it).toDto()
            }

    override fun findByEan(ean: String): ProductDto? =
        productRepository.findByEan(ean)
            ?.let { Product.fromRepositoryDto(it) }?.toDto()
}

fun ProductService.Companion.defaultService(productRepository: ProductRepository): ProductService =
    ProductServiceImpl(productRepository)