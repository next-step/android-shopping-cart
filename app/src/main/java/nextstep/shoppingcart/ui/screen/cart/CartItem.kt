package nextstep.shoppingcart.ui.screen.cart

import nextstep.shoppingcart.model.Product

data class CartItem(
    val count: Int = 1,
    val product: Product
)
