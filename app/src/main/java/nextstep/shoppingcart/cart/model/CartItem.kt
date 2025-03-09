package nextstep.shoppingcart.cart.model

import nextstep.shoppingcart.list.model.Product

data class CartItem(
    val product: Product,
    val count: Int,
) {
    val totalPrice: Int
        get() = product.price * count
}
