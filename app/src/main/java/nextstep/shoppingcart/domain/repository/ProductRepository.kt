package nextstep.shoppingcart.domain.repository

import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.Products

interface ProductRepository {
    fun getAllProducts(): Products

    fun getProductByIdOrNull(id: Int): Product?
}
