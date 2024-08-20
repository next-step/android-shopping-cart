package nextstep.shoppingcart.data.model

data class Product(
    val imageUrl: String = "https://picsum.photos/500",
    val name: String,
    val price: Int,
    val description: String
)
