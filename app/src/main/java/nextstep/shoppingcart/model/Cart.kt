package nextstep.shoppingcart.model

data class Cart(
    val product: Product,
    val count: Int,
) {
    val totalPrice: Int get() = product.price * count
}