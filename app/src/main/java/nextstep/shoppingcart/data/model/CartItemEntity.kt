package nextstep.shoppingcart.data.model

data class CartItemEntity(
    val product: ProductEntity,
    val quantity: Int,
)
