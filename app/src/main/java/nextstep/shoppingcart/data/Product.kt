package nextstep.shoppingcart.data

data class Product(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int,
    var count: Int = 0,
)