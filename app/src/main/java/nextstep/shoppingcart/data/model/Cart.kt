package nextstep.shoppingcart.data.model

data class Cart(
    val items: List<CartItem>
) {
    val totalPrice: Int get() = items.sumOf { it.totalPrice }

    fun getCountByProductId(id: Int) =
        items.find { it.productId == id }?.count ?: 0
}
