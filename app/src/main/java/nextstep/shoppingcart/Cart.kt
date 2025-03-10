package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.list.model.Product

object Cart {
    val items: SnapshotStateList<CartItem> = mutableStateListOf()

    val totalPrice: Int get() = items.sumOf { it.totalPrice }

    fun addOne(product: Product): List<CartItem> {
        val item = items.find { it.product == product }
        if (item == null) {
            items.add(CartItem(product, 1))
        } else {
            val index = items.indexOf(item)
            items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(productId: Int): List<CartItem> {
        items.find { it.product.id == productId }
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

    fun removeAll(productId: Int): List<CartItem> {
        items.removeAll { it.product.id == productId }
        return items
    }

    fun changeCount(productId: Int, count: Int) {
        items.find { it.product.id == productId }
            ?.let { item ->
                if (count < 1) {
                    items.remove(item)
                    return
                }
                val index = items.indexOf(item)
                items[index] = item.copy(count = count)
            }
    }
}
