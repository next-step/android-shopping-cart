package nextstep.shoppingcart.data

import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product

class FakeCart(
    private val _items: MutableList<CartItem> = mutableListOf(),
    private val incrementQuantity: Boolean = false,
    private val decrementQuantity: Boolean = false,
) : ShoppingCart {
    override val items: List<CartItem>
        get() = _items.toList()
    override val totalPrice: Int
        get() = items.sumOf { it.totalPrice }

    override fun add(product: Product): List<CartItem> {
        if (incrementQuantity && _items.isNotEmpty()) {
            _items[0] = _items[0].copy(quantity = _items[0].quantity + 1)
        } else {
            _items.add(CartItem(product, 1))
        }
        return items
    }

    override fun remove(product: Product): List<CartItem> {
        if (decrementQuantity && _items.isNotEmpty()) {
            val firstItem = _items[0]
            if (firstItem.quantity > 1) {
                _items[0] = firstItem.copy(quantity = firstItem.quantity - 1)
            } else {
                _items.removeAt(0)
            }
        } else {
            _items.removeIf { it.product == product }
        }
        return items
    }

    override fun cancel(cartItem: CartItem): List<CartItem> {
        _items.remove(cartItem)
        return items
    }

    override fun clear() {
        _items.clear()
    }
}
