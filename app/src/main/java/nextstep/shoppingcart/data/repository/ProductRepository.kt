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

    /**
     * 장바구니에 담긴 상품이 fetch한 상품 목록에 없을 경우도 대응해야 하지만 pass
     */
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
