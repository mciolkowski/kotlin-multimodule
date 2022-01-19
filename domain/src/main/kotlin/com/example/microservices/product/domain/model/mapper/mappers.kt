package com.example.microservices.product.domain.model.mapper

import com.example.microservices.product.domain.model.Product
import com.example.microservices.product.domain.model.dto.ProductDto
import com.example.microservices.product.domain.model.dto.ProductRepositoryDto

internal fun Product.toDto(): ProductDto =
    ProductDto(
        ean = ean,
        name = name,
        description = description
    )

internal fun Product.Companion.fromDto(productDto: ProductDto) = Product(
    ean = productDto.ean,
    name = productDto.name,
    description = productDto.description
)

internal fun Product.toRepositoryDto(): ProductRepositoryDto =
    ProductRepositoryDto(
        ean = ean,
        name = name,
        description = description
    )

internal fun Product.Companion.fromRepositoryDto(dto: ProductRepositoryDto) =
    Product(
        ean = dto.ean,
        name = dto.name,
        description = dto.description
    )

