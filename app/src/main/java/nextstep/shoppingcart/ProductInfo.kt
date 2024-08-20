package nextstep.shoppingcart

import java.io.Serializable

data class Product(
    val imageUrl: String,
    val name: String,
    val price: Int,
): Serializable
