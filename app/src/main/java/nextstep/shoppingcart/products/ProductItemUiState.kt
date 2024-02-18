package nextstep.shoppingcart.products

import java.io.Serializable

data class ProductItemUiState(
    val productName: String,
    val productPrice: Int,
    val productImageUrl: String,
) : Serializable {

    companion object {
        val Stub = ProductItemUiState(
            productName = "",
            productPrice = 0,
            productImageUrl = "",
        )
    }
}
