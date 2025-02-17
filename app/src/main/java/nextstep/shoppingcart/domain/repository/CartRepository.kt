package nextstep.shoppingcart.domain.repository

import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.Product

interface CartRepository {
    fun getCart(): Cart

    fun addOne(product: Product): Cart

    fun removeOne(product: Product): Cart

    fun removeAll(product: Product): Cart
}
