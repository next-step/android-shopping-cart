package nextstep.shoppingcart.domain.model

data class Product(
    val id: Int,
    val name: String,
    val price: Price,
    val imageUrl: String,
)
