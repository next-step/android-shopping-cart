package nextstep.shoppingcart.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import nextstep.shoppingcart.data.datasource.CartLocalDataSource
import nextstep.shoppingcart.data.model.CartItemEntity
import nextstep.shoppingcart.data.model.ProductEntity
import nextstep.shoppingcart.data.util.SingletonHolder

/**
 * 구현을 간소화하기 위해 interface 대신 구현체 바로 사용
 */
class CartRepository private constructor(
    private val cartLocalDataSource: CartLocalDataSource,
) {

    fun getItems(): Flow<List<CartItemEntity>> = cartLocalDataSource.itemsFlow.map { items ->
        items
    }

    fun addOne(product: ProductEntity) {
        cartLocalDataSource.addOne(product)
    }

    fun removeOne(product: ProductEntity) {
        cartLocalDataSource.removeOne(product)
    }

    fun removeAll(product: ProductEntity) {
        cartLocalDataSource.removeAll(product)
    }

    companion object : SingletonHolder<CartRepository>(
        creator = {
            CartRepository(CartLocalDataSource())
        }
    )
}
