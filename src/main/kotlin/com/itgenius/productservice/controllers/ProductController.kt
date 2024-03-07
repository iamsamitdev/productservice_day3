package com.itgenius.productservice.controllers

import com.itgenius.productservice.models.Product
import com.itgenius.productservice.services.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService: ProductService) {

    // Get all products
    // GET /api/v1/products
    @GetMapping
    fun getAllProducts(): List<Product> = productService.getAllProducts()

    // Get product by id
    // GET /api/v1/products/1
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<Product> {
        val product = productService.getProductById(id)
        return product.map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    // Create product
    // POST /api/v1/products
    // Request Body: {
    //     "productName": "Product 1",
    //     "productPrice": 100.00,
    //     "productDescription": "Product 1 description",
    //     "productQuantity": 10,
    //     "createdAt": "2021-08-01T00:00:00"
    // }
    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        val createdProduct = productService.createProduct(product)
        return ResponseEntity(createdProduct, HttpStatus.CREATED)
    }

    // Update product
    // PUT /api/v1/products/1
    // Request Body: {
    //     "productName": "Product 1",
    //     "productPrice": 100.00,
    //     "productDescription": "Product 1 description",
    //     "productQuantity": 10,
    //     "createdAt": "2021-08-01T00:00:00"
    // }
    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody updateProduct: Product): ResponseEntity<Product> {
        val updatedProduct = productService.updateProduct(id, updateProduct)
        return ResponseEntity(updatedProduct, HttpStatus.OK)
    }

    // Delete product
    // DELETE /api/v1/products/1
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Void> {
        productService.deleteProduct(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}