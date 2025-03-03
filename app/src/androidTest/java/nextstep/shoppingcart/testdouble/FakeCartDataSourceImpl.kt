package nextstep.shoppingcart.testdouble

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import nextstep.shoppingcart.cart.data.CartDataSource
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

class FakeCartDataSourceImpl(
    override val items: SnapshotStateList<CartItem> = mutableStateListOf()
) : CartDataSource {
    override val totalPrice: Int get() = items.sumOf { it.totalPrice }

    override fun getCount(product: Product): Int {
        println("장바구니에 있는 아이템: ${items.find { it.product.id == product.id }}")
        return items.find { product.id == it.product.id }?.count ?: 0
    }

    override fun hasProduct(product: Product): Boolean {
        println("장바구니에 있는지 여부: ${getCount(product) > 0}")
        return getCount(product) > 0
    }

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