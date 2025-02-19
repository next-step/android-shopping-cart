package nextstep.shoppingcart.domain.model

class Cart(
    initialItems: List<CartItem> = emptyList(),
) {
    val items: List<CartItem> = initialItems.toList()

    val totalPrice: Int get() = items.sumOf { it.totalPrice }

    fun addOne(product: Product): Cart {
        val itemForAddOne: CartItem? = items.find { it.product == product }
        if (itemForAddOne == null) {
            return Cart(items + (CartItem(product)))
        }

        val updatedItems = items.map { cartItem ->
            if (cartItem == itemForAddOne) {
                itemForAddOne.copy(count = itemForAddOne.count.increase())
            } else cartItem
        }
        return Cart(updatedItems)
    }

    fun removeOne(product: Product): Cart {
        val itemForRemoveOne = items.find { it.product == product }
        if (itemForRemoveOne == null) {
            return this
        }

        if (itemForRemoveOne.count == Count.ONE) {
            return Cart(items - itemForRemoveOne)
        }

        val updatedItems = items.map { cartItem ->
            if (cartItem == itemForRemoveOne) {
                itemForRemoveOne.copy(count = itemForRemoveOne.count.decrease())
            } else cartItem
        }

        return Cart(updatedItems)
    }

    fun removeAll(product: Product): Cart {
        val itemForRemoveAll = items.find { it.product == product }

        if (itemForRemoveAll == null) {
            return this
        }

        return Cart(items - itemForRemoveAll)
    }
}
