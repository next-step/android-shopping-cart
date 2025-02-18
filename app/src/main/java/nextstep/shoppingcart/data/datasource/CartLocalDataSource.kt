package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import nextstep.shoppingcart.data.model.CartItemEntity
import nextstep.shoppingcart.data.model.ProductEntity

class CartLocalDataSource {

    private val _items: MutableList<CartItemEntity> = mutableListOf()
    val items: Flow<CartItemEntity>
        get() = _items.asFlow()

    fun addOne(product: ProductEntity) {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItemEntity(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
    }

    fun removeOne(product: ProductEntity) {
        _items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _items.indexOf(item)
                    _items[index] = item.copy(count = item.count - 1)
                } else {
                    _items.remove(item)
                }
            }
    }

    fun removeAll(product: ProductEntity) {
        _items.removeAll { it.product == product }
    }
}
