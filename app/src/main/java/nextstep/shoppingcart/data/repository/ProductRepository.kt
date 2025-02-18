package nextstep.shoppingcart.data.repository

import nextstep.shoppingcart.data.datasource.ProductRemoteDataSource
import nextstep.shoppingcart.data.mapper.toUi
import nextstep.shoppingcart.data.util.SingletonHolder
import nextstep.shoppingcart.model.Product

class ProductRepository private constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
) {
    suspend fun fetch(): List<Product> {
        return productRemoteDataSource.fetch().map {
            it.toUi()
        }
    }

    companion object : SingletonHolder<ProductRepository>(
        creator = {
            ProductRepository(ProductRemoteDataSource())
        }
    )
}
