package nextstep.shoppingcart.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

object Cart {
    val items = mutableStateListOf<CartItem>()

    var totalPrice by mutableIntStateOf(0)
        private set

    private fun updateTotalPrice() {
        totalPrice = items.sumOf { it.totalPrice }
    }

    fun addOne(product: Product): List<CartItem> {
        val item = items.find { it.product == product }
        if (item == null) {
            items.add(CartItem(product, 1))
        } else {
            val index = items.indexOf(item)
            items[index] = item.copy(count = item.count + 1)
        }
        updateTotalPrice()
        return items
    }

    fun removeOne(product: Product): List<CartItem> {
        items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = items.indexOf(item)
                    items[index] = item.copy(count = item.count - 1)
                } else {
                    items.remove(item)
                }
            }
        updateTotalPrice()
        return items
    }

    fun removeAll(product: Product): List<CartItem> {
        items.removeAll { it.product == product }
        updateTotalPrice()
        return items
    }

    fun clear(): List<CartItem> {
        items.clear()
        updateTotalPrice()
        return items
    }
}