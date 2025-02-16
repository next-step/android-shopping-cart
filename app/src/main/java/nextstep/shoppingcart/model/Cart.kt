package nextstep.shoppingcart.model


object Cart {
    private val _items: MutableList<CartProductModel> = mutableListOf()
    val items: List<CartProductModel> get() = _items.toList()

    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: ProductModel): List<CartProductModel> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartProductModel(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(product: ProductModel): List<CartProductModel> {
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

    fun removeAll(product: ProductModel): List<CartProductModel> {
        _items.removeAll { it.product == product }
        return items
    }

    fun init() {
        _items.clear()
    }
}