package nextstep.shoppingcart.domain.repository

import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.Product

interface CartRepository {
    fun getCart(): Cart

    fun addOne(product: Product)

    fun removeOne(product: Product)

    fun removeAll(product: Product)
}
