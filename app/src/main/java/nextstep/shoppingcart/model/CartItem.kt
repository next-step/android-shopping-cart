package nextstep.shoppingcart.model

data class CartItem(
    val product: Product,
    val count: Int,
    val isShowCountButton: Boolean
) {
    val totalPrice: Int get() = product.price * count
}

object Cart {
    private val _items: MutableList<CartItem> = mutableListOf()
    val items: List<CartItem> get() = _items.toList()

    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: Product): List<CartItem> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItem(product, 1, true))
            val newItem = _items.find { it.product == product }
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1, isShowCountButton = true)
        }
        return items
    }

    fun getCountByProductName(productName: String): Int {
        return items.find { it.product.name == productName }?.count ?: 0
    }

    fun getButtonStateByProductName(productName: String): Boolean {
        return items.find { it.product.name == productName }?.isShowCountButton ?: false
    }

    fun removeOne(product: Product): List<CartItem> {
        _items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _items.indexOf(item)
                    _items[index] = item.copy(count = item.count - 1)
                } else {
                    _items.remove(item)
                }
            }
        return items
    }

    fun removeAll(product: Product): List<CartItem> {
        _items.removeAll { it.product == product }
        return items
    }

    fun clear() {
        _items.clear()
    }
}

