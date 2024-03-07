package com.itgenius.productservice.models

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "products")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int = 0,

    @Column(name = "product_name", nullable = false, length = 255)
    val productName: String,

    @Column(name = "product_price", nullable = false, precision = 10, scale = 2)
    val productPrice: BigDecimal = BigDecimal.ZERO,

    @Column(name = "product_description",  columnDefinition = "TEXT")
    val productDescription: String? = null,

    @Column(name = "product_quantity", nullable = false)
    val productQuantity: Int = 0,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

)
