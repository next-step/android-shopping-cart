package nextstep.shoppingcart.model

import kotlinx.serialization.Serializable

@Serializable
internal data class Product(
    val id: String,
    val name: String,
    val price: Int,
    val imageUrl: String?,
)
