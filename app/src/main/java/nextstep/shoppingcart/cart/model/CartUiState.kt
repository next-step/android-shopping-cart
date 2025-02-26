package nextstep.shoppingcart.cart.model

import nextstep.shoppingcart.model.CartItem

data class CartUiState(val totalPrice: Int, val cartItems: List<CartItem>)
