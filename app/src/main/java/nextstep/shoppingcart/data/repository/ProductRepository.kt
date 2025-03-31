package nextstep.shoppingcart.data.repository

import nextstep.shoppingcart.data.datasource.ProductLocalDataSource
import nextstep.shoppingcart.data.datasource.ProductRemoteDataSource
import nextstep.shoppingcart.data.model.ProductResponse
import nextstep.shoppingcart.data.util.SingletonHolder
import nextstep.shoppingcart.ui.mapper.toUi
import nextstep.shoppingcart.ui.model.Product

class ProductRepository private constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource,
) {
    val categories = productLocalDataSource.categoryFlow

    /**
     * 장바구니에 담긴 상품이 fetch한 상품 목록에 없을 경우도 대응해야 하지만 pass
     */
    suspend fun fetchCategory() {
        productLocalDataSource.updateCategory(productRemoteDataSource.fetchCategory())
    }

    suspend fun getProduct(category: String): List<ProductResponse> {
        return productRemoteDataSource.fetchProducts(category)
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
