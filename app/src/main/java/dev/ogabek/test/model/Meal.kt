package dev.ogabek.test.model

import java.io.Serializable

data class Meal(
    val id: Int,
    val name: String,
    val price: String,
    val deliveryInfo: String,
    val returnPolicy: String,
    val mainImage: Int,
    val images: ArrayList<Int>
): Serializable
