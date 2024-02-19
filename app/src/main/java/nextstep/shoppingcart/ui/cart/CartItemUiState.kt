package nextstep.shoppingcart.ui.cart

import nextstep.shoppingcart.domain.model.Product

data class CartItemUiState(
    val product: Product,
    val count: Int,
) {
    val totalPrice: Int get() = product.price * count
}
