package nextstep.shoppingcart.data.model

data class ProductResponse(
    val id: String,
    val imageUrl: String,
    val name: String,
    val category: String,
    val price: Int,
)
