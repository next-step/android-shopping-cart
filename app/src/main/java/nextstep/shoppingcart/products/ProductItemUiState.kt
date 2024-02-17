package nextstep.shoppingcart.products

import java.io.Serializable

data class ProductItemUiState(
    val productName: String,
    val productPrice: Int,
    val productImageUrl: String,
): Serializable
