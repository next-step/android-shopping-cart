package nextstep.shoppingcart.domain.model

data class Product(
    val id: Long,
    val name: String,
    val price: Int,
    val imgUrl: String,
)
