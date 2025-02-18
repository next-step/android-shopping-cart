package nextstep.shoppingcart.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.repository.CartRepository

object InMemoryCartRepository : CartRepository {
    val cart: MutableState<Cart> = mutableStateOf(Cart())

    override fun getCart(): Cart {
        return cart.value
    }

    override fun addOne(product: Product) {
        cart.value = cart.value.addOne(product)
    }

    override fun removeOne(product: Product) {
        cart.value = cart.value.removeOne(product)
    }

    override fun removeAll(product: Product) {
        cart.value = cart.value.removeAll(product)
    }
}
