package com.itgenius.productservice.services

import com.itgenius.productservice.models.Product
import com.itgenius.productservice.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ProductService (private val productRepository: ProductRepository) {

    // Get all products
    fun getAllProducts(): List<Product> = productRepository.findAll()

    // Get product by id
    fun getProductById(id: Int): Optional<Product> = productRepository.findById(id)

    // Create product
    fun createProduct(product: Product): Product = productRepository.save(product)

    // Update product
    fun updateProduct(id: Int, updateProduct: Product): Product {
        return  if (productRepository.existsById(id)) {
            updateProduct.id = id
            productRepository.save(updateProduct)
        } else {
            throw RuntimeException("Product not found with id $id")
        }
    }

    // Delete product
    fun deleteProduct(id: Int) {
        return if (productRepository.existsById(id)) {
            productRepository.deleteById(id)
        } else {
            throw RuntimeException("Product not found with id $id")
        }
    }

}