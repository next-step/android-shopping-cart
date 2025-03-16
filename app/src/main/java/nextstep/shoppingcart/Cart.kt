package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateListOf
import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.common.Products

object Cart {
    val items: MutableList<CartItem> = mutableStateListOf()

    val totalPrice: Int get() = items.sumOf { it.totalPrice }

    fun addOne(productId: Int) {
        val item = items.find { it.product.id == productId }
        if (item == null) {
            val product = Products.items.find { it.id == productId } ?: return
            items.add(CartItem(product, 1))
        } else {
            val index = items.indexOf(item)
            items[index] = item.copy(count = item.count + 1)
        }
    }

    fun removeAll(productId: Int): List<CartItem> {
        items.removeAll { it.product.id == productId }
        return items
    }

    fun changeCount(
        productId: Int,
        count: Int,
    ) {
        val item = items.find { it.product.id == productId }
        if (item == null) {
            val product = Products.items.find { it.id == productId } ?: return
            items.add(CartItem(product, count))
            return
        }
        if (count < 1) {
            items.remove(item)
            return
        }
        val index = items.indexOf(item)
        items[index] = item.copy(count = count)
    }
}
