package nextstep.shoppingcart.cart.data

import androidx.compose.runtime.snapshots.SnapshotStateList
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

interface CartDataSource {
    val items: SnapshotStateList<CartItem>
    val totalPrice: Int
    fun addOne(product: Product): List<CartItem>
    fun removeOne(product: Product): List<CartItem>
    fun removeAll(product: Product): List<CartItem>
}