package nextstep.shoppingcart.ui.cart

data class CartUiState(
    val items: List<CartItemUiState>,
) {
    val totalPrice: Int get() = items.sumOf { it.totalPrice }
}
