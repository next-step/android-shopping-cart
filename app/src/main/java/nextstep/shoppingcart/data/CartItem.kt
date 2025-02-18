package nextstep.shoppingcart.data

data class CartItem(
    val product: Product,
    var count: Int,
) {
    val totalPrice: Int
        get() = product.price * count
}