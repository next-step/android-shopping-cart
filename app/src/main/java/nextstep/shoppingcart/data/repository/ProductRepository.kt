package nextstep.shoppingcart.data.repository

import nextstep.shoppingcart.data.datasource.ProductLocalDataSource
import nextstep.shoppingcart.data.datasource.ProductRemoteDataSource
import nextstep.shoppingcart.data.mapper.toEntity
import nextstep.shoppingcart.data.util.SingletonHolder

class ProductRepository private constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource,
) {
    val categories = productLocalDataSource.categoryFlow
    val products = productLocalDataSource.itemsFlow

    /**
     * 장바구니에 담긴 상품이 fetch한 상품 목록에 없을 경우도 대응해야 하지만 pass
     */
    suspend fun fetchCategory() {
        productLocalDataSource.updateCategory(productRemoteDataSource.fetchCategory())
    }

    suspend fun fetchProduct(category: String) {
        productLocalDataSource.replaceAllItems(productRemoteDataSource.fetchProducts(category).map { it.toEntity() })
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
