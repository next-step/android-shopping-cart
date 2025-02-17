package nextstep.shoppingcart.data

import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.repository.CartRepository

object InMemoryCartRepository : CartRepository {
    private var cart: Cart = Cart()

    override fun getCart(): Cart {
        return cart
    }

    override fun addOne(product: Product): Cart {
        cart = cart.addOne(product)
        return cart
    }

    override fun removeOne(product: Product): Cart {
        cart = cart.removeOne(product)
        return cart
    }

    override fun removeAll(product: Product): Cart {
        cart = cart.removeAll(product)
        return cart
    }
}
