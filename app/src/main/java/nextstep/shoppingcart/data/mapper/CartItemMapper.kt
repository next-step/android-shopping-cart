package nextstep.shoppingcart.data.mapper

import nextstep.shoppingcart.data.model.CartItemEntity
import nextstep.shoppingcart.model.CartItem

fun CartItemEntity.toUi(): CartItem {
    return CartItem(
        product = product.toUi(),
        count = count,
    )
}
