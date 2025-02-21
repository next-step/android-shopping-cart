package nextstep.shoppingcart.data.repository

import nextstep.shoppingcart.data.datasource.ProductRemoteDataSource
import nextstep.shoppingcart.data.model.ProductEntity
import nextstep.shoppingcart.data.util.SingletonHolder

class ProductRepository private constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
) {
    suspend fun fetch(): List<ProductEntity> {
        return productRemoteDataSource.fetch()
    }

    companion object : SingletonHolder<ProductRepository>(
        creator = {
            ProductRepository(ProductRemoteDataSource())
        }
    )
}
