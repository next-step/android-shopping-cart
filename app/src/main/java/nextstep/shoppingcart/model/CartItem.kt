package nextstep.shoppingcart.model

data class CartItem(
    val product: Product,
    val count: CartCount,
) {
    val totalPrice: Long get() = product.price * count.value
    fun addOne() = copy(count = count.inc())
    fun removeOne() = copy(count = count.dec())
}
