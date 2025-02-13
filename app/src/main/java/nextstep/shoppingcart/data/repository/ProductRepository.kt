package nextstep.shoppingcart.data.repository

import nextstep.shoppingcart.data.model.Product

interface ProductRepository {
    fun getProductList(): List<Product>
}
