package nextstep.shoppingcart.testdouble

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import nextstep.shoppingcart.cart.data.CartDataSource
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

class FakeCartDataSource(
    override val items: SnapshotStateList<CartItem> = mutableStateListOf()
) : CartDataSource {
    override val totalPrice: Int get() = items.sumOf { it.totalPrice }

    override fun addOne(product: Product): List<CartItem> {
        val item = items.find { it.product == product }
        if (item == null) {
            items.add(CartItem(product, 1))
        } else {
            val index = items.indexOf(item)
            items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    override fun removeOne(product: Product): List<CartItem> {
        items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = items.indexOf(item)
                    items[index] = item.copy(count = item.count - 1)
                } else {
                    items.remove(item)
                }
            }
        return items
    }

    override fun removeAll(product: Product): List<CartItem> {
        items.removeAll { it.product == product }
        return items
    }
}