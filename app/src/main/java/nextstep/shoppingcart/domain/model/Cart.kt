package nextstep.shoppingcart.domain.model

data class Cart(
    val items: List<Item>,
) {
    val totalPrice: Int get() = items.sumOf { it.totalPrice }
    
    fun findItemByProductId(productId: String): Item? {
        return items.find { it.product.id == productId }
    }

    data class Item(
        val product: Product,
        val count: Int,
    ) {
        val totalPrice: Int get() = product.price * count
    }
}
