package nextstep.shoppingcart.domain.model

data class CartItem(
    val product: Product,
    val count: Int,
) {
    val totalPrice: Int = product.price * count
}
