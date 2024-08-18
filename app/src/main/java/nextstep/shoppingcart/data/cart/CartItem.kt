package nextstep.shoppingcart.data.cart

import nextstep.shoppingcart.data.Product

data class CartItem(
    val product: Product,
    val count: Int,
) {
    val totalPrice: Int get() = product.price * count
}

