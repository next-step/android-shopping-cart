package nextstep.shoppingcart.data

import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product


interface ShoppingCart {
    val items: List<CartItem>
    val totalPrice: Int
    fun addOne(product: Product): List<CartItem>
    fun removeOne(product: Product): List<CartItem>
    fun removeAll(product: Product): List<CartItem>
}
