package nextstep.shoppingcart.data

import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.Product

object CartRepository {
    private var cachedCart: Cart = Cart(emptyList())

    fun getCart(): Cart = cachedCart

    fun addToCart(product: Product): Cart {
        val items = cachedCart.items

        val item = items.find { it.product.id == product.id }
        val newItem = item?.copy(count = item.count + 1) ?: Cart.Item(product, 1)
        val newItems = if (item != null) {
            items.map { if (it.product.id == product.id) newItem else it }
        } else {
            items + newItem
        }
        cachedCart = cachedCart.copy(items = newItems)
        return cachedCart
    }

    fun removeAllFromCart(product: Product): Cart {
        val items = cachedCart.items
        val newItems = items.filter { it.product.id != product.id }
        cachedCart = cachedCart.copy(items = newItems)
        return cachedCart
    }

    fun removeFromCart(product: Product): Cart {
        val items = cachedCart.items
        val item = items.find { it.product.id == product.id }
        val newItems = if (item != null) {
            if (item.count > 1) {
                items.map { if (it.product.id == product.id) item.copy(count = item.count - 1) else it }
            } else {
                items.filter { it.product.id != product.id }
            }
        } else {
            items
        }
        cachedCart = cachedCart.copy(items = newItems)
        return cachedCart
    }
}
