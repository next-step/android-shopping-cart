package nextstep.shoppingcart.model

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

object Cart {
    val items: SnapshotStateList<CartItem> = mutableStateListOf()
    val totalPrice: State<Long> = derivedStateOf { items.sumOf { it.totalPrice } }

    fun addOne(product: Product): List<CartItem> {
        val item = items.find { it.product == product }
        if (item == null) {
            items.add(CartItem(product, CartCount.INIT_COUNT))
        } else {
            val index = items.indexOf(item)
            items[index] = item.addOne()
        }
        return items
    }

    fun removeOne(product: Product): List<CartItem> {
        items.find { it.product == product }
            ?.let { item ->
                if (item.count == CartCount.INIT_COUNT) {
                    items.remove(item)
                } else {
                    val index = items.indexOf(item)
                    items[index] = item.removeOne()
                }
            }
        return items
    }

    fun removeAll(product: Product): List<CartItem> {
        items.removeAll { it.product == product }
        return items
    }
}
