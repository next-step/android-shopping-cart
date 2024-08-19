package nextstep.shoppingcart.domain.model

data class ProductItem(
    val product: Product,
    val isInCart: Boolean,
    val quantity: Int,
)
