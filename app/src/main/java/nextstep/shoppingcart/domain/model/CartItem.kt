package nextstep.shoppingcart.domain.model

data class CartItem(
    val product: Product,
    val count: Count = Count.ONE,
) {
    val totalPrice: Int get() = product.price.value * count.value
}
