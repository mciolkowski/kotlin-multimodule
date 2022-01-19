package com.example.microservices.product.app.configuration

import com.example.microservices.product.domain.repository.ProductRepository
import com.example.microservices.product.domain.service.ProductService
import com.example.microservices.product.domain.service.impl.defaultService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.example.microservices.product"])
class ApplicationConfig(
    val productRepository: ProductRepository
) {

    @Bean
    fun productService() = ProductService.defaultService(productRepository)
}