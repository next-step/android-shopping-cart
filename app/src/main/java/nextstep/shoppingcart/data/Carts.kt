package nextstep.shoppingcart.data

import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product

interface Carts {
    val items: List<CartItem>
    val totalPrice: Int

    fun add(product: Product): List<CartItem>

    fun remove(product: Product): List<CartItem>

    fun removeAll(): List<CartItem>
}

class CartsImpl : Carts {
    private val _items: MutableList<CartItem> = mutableListOf()
    override val items: List<CartItem>
        get() = TODO("Not yet implemented")
    override val totalPrice: Int
        get() = TODO("Not yet implemented")

    override fun add(product: Product): List<CartItem> {
        TODO("Not yet implemented")
    }

    override fun remove(product: Product): List<CartItem> {
        TODO("Not yet implemented")
    }

    override fun removeAll(): List<CartItem> {
        TODO("Not yet implemented")
    }
}
