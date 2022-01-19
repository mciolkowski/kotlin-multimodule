package com.example.microservices.product.domain.model

import com.example.microservices.product.domain.model.dto.ProductDto
import com.example.microservices.product.domain.model.dto.ProductRepositoryDto
import com.example.microservices.product.domain.model.mapper.fromDto
import com.example.microservices.product.domain.model.mapper.fromRepositoryDto
import com.example.microservices.product.domain.model.mapper.toDto
import com.example.microservices.product.domain.model.mapper.toRepositoryDto
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ProductTest {
    private val ean = "123"
    private val name = "Prod1"
    private val description = "Description"

    @Test
    fun `should map product to DTO`() {
        // given
        val product = Product(ean, name, description)
        // when
        val dto = product.toDto()
        // then
        assertEquals(ean, dto.ean)
        assertEquals(name, dto.name)
        assertEquals(description, dto.description)
    }

    @Test
    fun `should create product from DTO`() {
        // given
        val dto = ProductDto(ean, name, description)
        // when
        val product = Product.fromDto(dto)
        // then
        assertEquals(ean, product.ean)
        assertEquals(name, product.name)
        assertEquals(description, product.description)
    }

    @Test
    fun `should map product to repository DTO`() {
        // given
        val product = Product(ean, name, description)
        // when
        val dto = product.toRepositoryDto()
        // then
        assertEquals(product.ean, dto.ean)
        assertEquals(product.name, dto.name)
        assertEquals(product.description, dto.description)
    }

    @Test
    fun `should create product from  repository DTO`() {
        // given
        val dto = ProductRepositoryDto(ean, name, description)
        // when
        val product = Product.fromRepositoryDto(dto)
        // then
        assertEquals(dto.ean, product.ean)
        assertEquals(dto.name, product.name)
        assertEquals(dto.description, product.description)
    }
}