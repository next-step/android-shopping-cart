package nextstep.shoppingcart.data.model

data class CartItem(
    val product: Product,
    val count: Int,
) {
    val productName = product.name
    val productImageUrl = product.imageUrl

    val totalPrice: Int get() = product.price * count
}
