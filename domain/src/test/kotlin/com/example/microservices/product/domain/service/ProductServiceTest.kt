package com.example.microservices.product.domain.service

import com.example.microservices.product.domain.model.Product
import com.example.microservices.product.domain.model.dto.ProductRepositoryDto
import com.example.microservices.product.domain.model.mapper.fromRepositoryDto
import com.example.microservices.product.domain.model.mapper.toDto
import com.example.microservices.product.domain.repository.ProductRepository
import com.example.microservices.product.domain.service.impl.defaultService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

internal class ProductServiceTest {
    private val ean1 = "123"
    private val ean2 = "456"
    private val product1 = ProductRepositoryDto(ean1, "name1", "desc1")
    private val product2 = ProductRepositoryDto(ean2, "name2", "desc2")

    private val productRepository: ProductRepository = mockk()

    private val productService: ProductService = ProductService.defaultService(productRepository)

    @Test
    internal fun `should return products by find all`() {
        // given
        val products = listOf(product1, product2)
        every { productRepository.findAll() } returns products
        // when
        val foundProducts = productService.findAll()
        // then
        assertEquals(2, foundProducts.size)
        assertContains(foundProducts, transformToProductDto(product1))
        assertContains(foundProducts, transformToProductDto(product2))
    }

    @Test
    internal fun `should return product by ean`() {
        // given
        every { productRepository.findByEan(ean1) } returns product1
        // when
        val foundProduct = productService.findByEan(ean1)
        // then
        assertNotNull(foundProduct)
        assertEquals(transformToProductDto(product1), foundProduct)
    }

    @Test
    internal fun `should not return product when not found by ean`() {
        // given
        every { productRepository.findByEan(ean1) } returns product1
        every { productRepository.findByEan(ean2) } returns null
        // when
        val foundProduct = productService.findByEan(ean2)
        // then
        assertNull(foundProduct)
    }

    private fun transformToProductDto(dto: ProductRepositoryDto) = Product.fromRepositoryDto(dto).toDto()
}