package nextstep.shoppingcart.data.repository

import nextstep.shoppingcart.data.datasource.ProductLocalDataSource
import nextstep.shoppingcart.data.datasource.ProductRemoteDataSource
import nextstep.shoppingcart.data.mapper.toEntity
import nextstep.shoppingcart.data.model.ProductEntity
import nextstep.shoppingcart.data.util.SingletonHolder

class ProductRepository private constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource,
) {
    val products = productLocalDataSource.itemsFlow

    suspend fun fetch() {
        productLocalDataSource.replaceAll(productRemoteDataSource.fetch().map { it.toEntity() })
    }

    fun update(product: ProductEntity) {
        productLocalDataSource.update(product)
    }

    companion object : SingletonHolder<ProductRepository>(
        creator = {
            ProductRepository(
                productRemoteDataSource = ProductRemoteDataSource(),
                productLocalDataSource = ProductLocalDataSource(),
            )
        }
    )
}
