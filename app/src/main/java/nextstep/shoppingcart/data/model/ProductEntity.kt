package nextstep.shoppingcart.data.model

data class ProductEntity(
    val id: String,
    val imageUrl: String,
    val name: String,
    val category: String,
    val price: Int,
)
