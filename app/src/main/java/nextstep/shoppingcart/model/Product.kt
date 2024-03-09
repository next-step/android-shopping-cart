package nextstep.shoppingcart.model

data class Product(
    val id: Long = Long.MIN_VALUE,
    val imageUrl: String = "",
    val name: String = "",
    val price: Int = Int.MIN_VALUE
)
