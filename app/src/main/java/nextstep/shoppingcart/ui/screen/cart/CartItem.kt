package nextstep.shoppingcart.ui.screen.cart

import nextstep.shoppingcart.ui.screen.products.model.ProductModel

data class CartItem(
    val product: ProductModel,
    val count: Int,
) {
    val totalPrice: Int get() = product.price * count
}
