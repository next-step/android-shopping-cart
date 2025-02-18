package nextstep.shoppingcart.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import nextstep.shoppingcart.data.datasource.CartRemoteDataSource
import nextstep.shoppingcart.data.mapper.toEntity
import nextstep.shoppingcart.data.mapper.toUi
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

/**
 * 구현을 간소화하기 위해 interface 대신 구현체 바로 사용
 */
class CartRepository(
    private val cartRemoteDataSource: CartRemoteDataSource,
) {

    fun getItems(): Flow<CartItem> = cartRemoteDataSource.items.map {
        it.toUi()
    }

    fun addOne(product: Product) {
        cartRemoteDataSource.addOne(product.toEntity())
    }

    fun removeOne(product: Product) {
        cartRemoteDataSource.removeOne(product.toEntity())
    }

    fun removeAll(product: Product) {
        cartRemoteDataSource.removeAll(product.toEntity())
    }
}
