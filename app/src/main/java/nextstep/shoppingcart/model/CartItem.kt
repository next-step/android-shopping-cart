package nextstep.shoppingcart.model

data class CartItem(
    val product: Product,
    val count: Int
) {
    val totalPrice: Int get() = product.price * count
}

val dummyCartItem = CartItem(
    product = Product(
        id = "",
        imageUrl = "https://picsum.photos/200",
        name = "셀프 마라탕 (기본 12000원)",
        price = 18500
    ),
    count = 1
)