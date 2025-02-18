package nextstep.shoppingcart.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import nextstep.shoppingcart.data.datasource.CartLocalDataSource
import nextstep.shoppingcart.data.mapper.toEntity
import nextstep.shoppingcart.data.mapper.toUi
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

/**
 * 구현을 간소화하기 위해 interface 대신 구현체 바로 사용
 */
class CartRepository(
    private val cartLocalDataSource: CartLocalDataSource,
) {

    fun getItems(): Flow<List<CartItem>> = cartLocalDataSource.itemsFlow.map { items ->
        items.map {
            it.toUi()
        }
    }

    fun addOne(product: Product) {
        cartLocalDataSource.addOne(product.toEntity())
    }

    fun removeOne(product: Product) {
        cartLocalDataSource.removeOne(product.toEntity())
    }

    fun removeAll(product: Product) {
        cartLocalDataSource.removeAll(product.toEntity())
    }

    companion object {
        fun inject(): CartRepository {
            return CartRepository(CartLocalDataSource())
        }
    }
}
