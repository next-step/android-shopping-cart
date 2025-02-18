package nextstep.shoppingcart.model

import nextstep.shoppingcart.data.model.ProductEntity

data class CartItem(
    val product: ProductEntity,
    val count: Int,
) {
    val totalPrice: Int get() = product.price * count
}
