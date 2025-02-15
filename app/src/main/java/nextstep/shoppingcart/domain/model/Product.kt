package nextstep.shoppingcart.domain.model

data class Product(
    val id: Int,
    val name: String,
    val price: Price,
    val imageUrl: String,
) {
    companion object {
        val NotFound = Product(
            id = Int.MIN_VALUE,
            name = "No product found",
            price = Price.of(0),
            imageUrl = ""
        )
    }
}
