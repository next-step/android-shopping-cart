package nextstep.shoppingcart.model

import androidx.compose.runtime.mutableLongStateOf


object Cart {
    private var _updatedTime = mutableLongStateOf(System.currentTimeMillis())
    val updateTime = _updatedTime

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
        updated()
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
        updated()
        return items
    }

    fun removeAll(product: ProductModel): List<CartProductModel> {
        _items.removeAll { it.product == product }
        updated()
        return items
    }

    fun init() {
        _items.clear()
        updated()
    }

    fun productCount(model: ProductModel): Int {
        return items.firstOrNull { it.id == model.id }?.count ?: 0
    }

    private fun updated() {
        _updatedTime.longValue = System.currentTimeMillis()
    }
}