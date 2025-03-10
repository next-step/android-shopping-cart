package nextstep.shoppingcart.data.repository

import kotlinx.coroutines.flow.Flow
import nextstep.shoppingcart.data.datasource.CartLocalDataSource
import nextstep.shoppingcart.data.model.CartItemEntity
import nextstep.shoppingcart.data.model.ProductEntity
import nextstep.shoppingcart.data.util.SingletonHolder

class CartRepository private constructor(
    private val cartLocalDataSource: CartLocalDataSource,
) {

    val items: Flow<LinkedHashMap<String, CartItemEntity>> = cartLocalDataSource.items

    fun update(cartItem: CartItemEntity) {
        cartLocalDataSource.update(cartItem)
    }

    companion object : SingletonHolder<CartRepository>(
        creator = {
            CartRepository(CartLocalDataSource())
        }
    )
}
