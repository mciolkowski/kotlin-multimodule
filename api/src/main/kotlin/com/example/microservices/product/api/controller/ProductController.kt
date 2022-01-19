package com.example.microservices.product.api.controller

import com.example.microservices.product.domain.model.dto.ProductDto
import com.example.microservices.product.domain.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/product")
@RestController
class ProductController(private val productService: ProductService) {

    @GetMapping("/")
    fun findAll(): Collection<ProductDto> = productService.findAll()
}